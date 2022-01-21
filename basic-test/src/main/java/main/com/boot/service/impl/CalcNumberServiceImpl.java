package main.com.boot.service.impl;

import main.com.boot.entity.NumberRecord;
import main.com.boot.mapper.NumberRecordMapper;
import main.com.boot.param.RecordParam;
import main.com.boot.service.ICalcNumberService;
import main.com.boot.service.INumberRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @name: CalcNumberServiceImpl
 * @author: mubai.
 * @date: 2021/11/26
 * @version: 1.0
 * @description: <pre>
 *     市面上流行的数字游戏玩法:
 *     1、array[20][5]，每轮游戏由5个数字组成，每次录入最新的20轮游戏
 *     2、每回合根据20轮的数字，比较得到最优结果：
 *     <pre>
 *         a)如果上一次计算结果非空，则比较每个数字是否发生变化，如果否则直接返回上一次的计算结果(重新获取求余结果)，如果是则返回返回对应变化位数的最优结果
 *         b)如果上一次的结算结果为空，则根据当前20组数字得出结果
 *         c)如果20组数字未出现的数字大于1个，则同样根据最近一轮数字的大小和奇偶特性获取概率最大的数字
 *     </pre>
 *     3、返回的数据包含以下格式:
 *     <pre>
 *         a) 最优结果的五位数字
 *         b) 需要返回当前数字累计比较次数(当前数组里面的最大未出现次数,如果当前20size的集合里都不包含该数字，则需要+比较累计次数)
 *         c) 计算结果的优先级根据累计比较次数的大小进行排序，当次数>20时，默认概率为100%，当比较次数小于20时，(20-当前累计次数)/20 * 100 等于当前概率
 *         当前概率+最近一轮数字的大小和奇偶特性，来计算期望范围，期望结果同样输出到结果中
 *         d) 根据上一步得到的期望结果和最大概率组合来获取5个数字对10的求余结果，该结果只能返回一个
 *     </pre>
 * </pre>
 * <pre>
 *     该数字游戏包含以下知识点：
 *     1、双维度的数据计算，根据冒泡结果得到最低出现概率
 *     2、结果计算因子未来扩展一下玄学? (某种随机数计算后折换成的概率比，但是需要保证一定的逻辑性质)
 *     <pre>
 *         选择因子，该随机数以累计比较次数的增加来得到曲线概率，该曲线概率大于一定返回时会给
 *     </pre>
 * </pre>
 * <pre>
 *     单元测试案例：
 *     1、使用定时任务每5分钟进行一次计算，得出的结果和下一轮结果比较，每正确一个则输出一个string到结果表，输出格式如下:
 *     <pre>测试时间+上一轮计算结果+下一轮结果+预测正确的数字和求余结果</pre>
 *     2、每个数字的返回是0~9，返回的结果命中时*10，起始筹码为100，每次投入2*5，比较正确 2*10*n计入筹码，程序执行n次之后根据结果输出的string
 *     和筹码池来得出结果
 * </pre>
 * <pre>
 *     后期扩展：
 *     1、每次比较的结果记录到表，得到比较趋势
 *     2、每次比较，需要根据累计比较次数，累计预测失败次数，过去30次数据中奇偶大小特性，给出一个倾向性选择
 *     3、2021-11-27 扩展：对于近二十个数字没有出现的情况，需要在筛选奇偶大小特性之后根据距离当前最远的距离比较来获取结果
 * </pre>
 *
 * <pre>
 *     编码日志：
 *     1、2021-11-23 完成基础代码输入输出的编写
 *     2、2021-11-25 集成数据库表，保证历史数据保持不变
 * </pre>
 */
@Service
@Slf4j
public class CalcNumberServiceImpl implements ICalcNumberService {
    @Autowired
    private INumberRecordService iNumberRecordService;
    @Resource
    private NumberRecordMapper numberRecordMapper;


    /**
     * 进行最新记录存储
     *
     * @param recordParam 入参
     * @return 存储结果
     */
    @Override
    public String saveRecord(RecordParam recordParam) {
        NumberRecord numberRecord = new NumberRecord();
        BeanUtils.copyProperties(recordParam, numberRecord);
        numberRecord.setYsNum(calcQy(numberRecord));
        iNumberRecordService.save(numberRecord);
        return calcRecord();
    }

    /**
     * 预测结果
     *
     * @return 返回结果字符串
     */
    @Override
    public String calcRecord() {
        List<NumberRecord> records = numberRecordMapper.getRecentNum();
        //获取最近一次查询结果
        log.info("当前数据->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        StringBuilder builder = new StringBuilder();
        for (int i = records.size() - 1; i >= 0; i--) {
            log.info("{}:{}\t{}\t{}\t{}\t{}", records.get(i).getRecordKey(), records.get(i).getNum1(),
                    records.get(i).getNum2(), records.get(i).getNum3(), records.get(i).getNum4(), records.get(i).getNum5());
            builder.append(records.get(i).getRecordKey()).append("：").append(records.get(i).getNum1()).append("    ")
                    .append(records.get(i).getNum2()).append("    ")
                    .append(records.get(i).getNum3()).append("    ")
                    .append(records.get(i).getNum4()).append("    ")
                    .append(records.get(i).getNum5()).append("\n");
        }
        //默认最后一轮数字等于最近一次的结果
        log.info("开始计算预测->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        //获取最优解
        List<Integer> finalNum = calcBestNumber(records, builder);
        builder.append(" calc result：");
        finalNum.forEach(num -> builder.append(num).append("    "));
        builder.append("\n");
        return builder.toString();
    }

    /**
     * 进行求余
     *
     * @param numberRecord 数据集
     */
    private Integer calcQy(NumberRecord numberRecord) {
        int total = (numberRecord.getNum1() == 0 ? 10 : numberRecord.getNum1()) +
                (numberRecord.getNum2() == 0 ? 10 : numberRecord.getNum2()) +
                (numberRecord.getNum3() == 0 ? 10 : numberRecord.getNum3()) +
                (numberRecord.getNum4() == 0 ? 10 : numberRecord.getNum4()) +
                (numberRecord.getNum5() == 0 ? 10 : numberRecord.getNum5());
        return total < (numberRecord.getNum1() == 0 || numberRecord.getNum2() == 0 ||
                numberRecord.getNum3() == 0 || numberRecord.getNum4() == 0 || numberRecord.getNum5() == 0 ? 10 : 20)
                ? null : total % 10;
    }

    /**
     * 获取最小结果
     *
     * @param records 过去20轮结果
     * @return 最优解
     */
    public static List<Integer> calcBestNumber(List<NumberRecord> records, StringBuilder builder) {
        /*
         * 倒序进行运算
         */
        Map<Integer, List<Integer>> defaultMap = getDefaultNumberMap();
        for (NumberRecord record : records) {
            //去除defaultMap的数据
            if (defaultMap.get(0).contains(record.getNum1())) {
                List<Integer> temp = new ArrayList<>(defaultMap.get(0));
                temp.remove(record.getNum1());
                defaultMap.put(0, temp);
            }
            if (defaultMap.get(1).contains(record.getNum2())) {
                List<Integer> temp = new ArrayList<>(defaultMap.get(1));
                temp.remove(record.getNum2());
                defaultMap.put(1, temp);
            }
            if (defaultMap.get(2).contains(record.getNum3())) {
                List<Integer> temp = new ArrayList<>(defaultMap.get(2));
                temp.remove(record.getNum3());
                defaultMap.put(2, temp);
            }
            if (defaultMap.get(3).contains(record.getNum4())) {
                List<Integer> temp = new ArrayList<>(defaultMap.get(3));
                temp.remove(record.getNum4());
                defaultMap.put(3, temp);
            }
            if (defaultMap.get(4).contains(record.getNum5())) {
                List<Integer> temp = new ArrayList<>(defaultMap.get(4));
                temp.remove(record.getNum5());
                defaultMap.put(4, temp);
            }
        }
        //遍历完成
        return getFinalNumber(defaultMap, records.get(0), builder);
    }

    /*
     * 获取最终结果
     */
    public static List<Integer> getFinalNumber(Map<Integer, List<Integer>> defaultMap, NumberRecord record, StringBuilder builder) {
        List<Integer> result = new ArrayList<>();
        defaultMap.forEach((key, value) -> {
            System.out.print("第" + key + "位近20位过滤数字:");
            builder.append("第").append(key).append("位近20位过滤数字：");
            value.forEach(number -> {
                System.out.print(number + "\t");
                builder.append(number).append("    ");
            });
            builder.append("\n");
            System.out.println();
            if (value.size() == 1) {
                result.add(value.get(0));
            } else {
                if (key == 0) {
                    result.add(calcNumber(value, record.getNum1()));
                }
                if (key == 1) {
                    result.add(calcNumber(value, record.getNum2()));
                }
                if (key == 2) {
                    result.add(calcNumber(value, record.getNum3()));
                }
                if (key == 3) {
                    result.add(calcNumber(value, record.getNum4()));
                }
                if (key == 4) {
                    result.add(calcNumber(value, record.getNum5()));
                }
            }
        });
        return result;
    }

    /**
     * 计算玄学结果
     *
     * @param defaultNum 去除之后的数组
     * @param lastNum    最近一次结果
     * @return 玄学结果
     */
    public static Integer calcNumber(List<Integer> defaultNum, Integer lastNum) {
        //获取范围,和最后结果相反区间，以5作为分隔
        int begin = lastNum >= 5 ? 0 : 5;
        int end = lastNum >= 5 ? 5 : 10;
        boolean b = lastNum % 2 == 0;
        if (defaultNum.size() == 0) {
            return getXuanxueNumber(begin, end, b);
        } else {
            //这里肯定大于1，所以返回随机值即可
            List<Integer> tempNum = new ArrayList<>(defaultNum);
            if (b) {
                tempNum = defaultNum.stream().filter(item -> item % 2 == 1).collect(Collectors.toList());
            } else {
                tempNum = defaultNum.stream().filter(item -> item % 2 == 0).collect(Collectors.toList());
            }
            Random random = new Random();
            if (tempNum.size() == 0) {
                return defaultNum.get(random.nextInt(defaultNum.size() - 1));
            }
            if (tempNum.size() == 1) {
                return tempNum.get(0);
            }
            return tempNum.get(random.nextInt(tempNum.size() - 1));
        }
    }

    /**
     * 获取玄学数字，这里后面可以扩展玄学因子
     */
    public static Integer getXuanxueNumber(Integer begin, Integer end, boolean b) {
        Random random = new Random();
        List<Integer> tempInteger = getDefaultNumberList(begin, end);
        List<Integer> rangeNumber;
        if (b) {
            rangeNumber = tempInteger.stream().filter(item -> item % 2 == 1).collect(Collectors.toList());
        } else {
            rangeNumber = tempInteger.stream().filter(item -> item % 2 == 0).collect(Collectors.toList());
        }
        return rangeNumber.get(random.nextInt(rangeNumber.size() - 1));
    }

    public static Map<Integer, List<Integer>> getDefaultNumberMap() {
        Map<Integer, List<Integer>> result = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            result.put(i, getDefaultNumberList(0, 10));
        }
        return result;
    }

    /**
     * 获取默认数字集
     */
    public static List<Integer> getDefaultNumberList(Integer begin, Integer end) {
        List<Integer> result = new ArrayList<>();
        for (int i = begin; i < end; i++) {
            result.add(i);
        }
        return result;
    }

    /**
     * 随机获取初始数值
     *
     * @return 返回随机得到的二维数组
     */
    public static Map<Integer, List<Integer>> getInitArray() {
        Random random = new Random();
        Map<Integer, List<Integer>> result = new HashMap<>();
        for (int i = 0; i < 20; i++) {
            List<Integer> inner = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                inner.add(random.nextInt(10));
            }
            result.put(i, inner);
        }
        return result;
    }
}
