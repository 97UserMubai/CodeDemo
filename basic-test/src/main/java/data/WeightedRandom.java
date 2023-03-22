package data;

/**
 * @name: WeightedRandom
 * @author: Mubai.Wang
 * @date: 2023/2/24
 * @version: 1.0
 * @description:
 */

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WeightedRandom {

    public static void main(String[] args) {
        Map<String, Double> map = new HashMap<>();
        // 总和不一定非要等于100，是为了方便理解代码
        map.put("1号", 1.0);
        map.put("2号", 5.0);
        map.put("3号", 5.0);
        map.put("4号", 5.0);
        map.put("5号", 4.0);
        map.put("6号", 25.0);
        map.put("7号", 10.0);
        map.put("8号", 10.0);
        map.put("9号", 30.0);
        map.put("10号", 50.0);
        map.put("11号", 30.0);
        map.put("12号", 40.0);
        map.put("13号", 15.0);
        map.put("14号", 10.0);
        map.put("15号", 10.0);
        map.put("16号", 10.0);
        map.put("17号", 10.0);
        map.put("18号", 10.0);
        map.put("19号", 5.0);
        map.put("20号", 5.0);
        map.put("21号", 5.0);
        map.put("22号", 1.0);
        // (输入值，生成多少个数)
        List<String> result = getResult(map, 10000);
        Map<String, Long> mapResult = result.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(mapResult);
    }

    class Bean {
        String key;
        double sumWeight;
    }

    // 将所有的bean放在一个集合中
    List<Bean> beans = new ArrayList<>();
    // 总权重
    double sumWeight;

    // 将单个实体放入到实体集合中
    public void addBean(String key, double weight) {
        // 计算总权重
        sumWeight += weight;
        // 给bean赋值
        Bean b = new Bean();
        b.key = key;
        b.sumWeight = sumWeight;
        // 放入集合
        beans.add(b);

    }

    public String getRandom() {
        // 生成介于0.0到100.0的数
        double r = new Random().nextDouble() * sumWeight;
        // 遍历所有实体
        for (Bean bean : beans) {
            // 如果目前遍历的实体和大于这个随机数则将其输出
            /*
            举例：
            若权重和为100，生成的随机数为8.8，那么会得到三等奖
            因为map的值是这样的{三等奖=10.0, 谢谢参与=54.0, 一等奖=1.0, 安慰奖=30.0, 二等奖=5.0}
            而10.0(目前遍历的集合元素的权重和) > 8.8的，所以是三等奖
            即[0,10]三等奖，(10,64]谢谢参与，(64,65]一等奖，(65,95]安慰奖，(95,100]二等奖
            即我们需要的概率
             */
            if (bean.sumWeight >= r) {
                return bean.key;
            }
        }
        return null;
    }

    public static List<String> getResult(Map<String, Double> map, int count) {
        List<String> list = new ArrayList<>();
        // 每一个map对应一个WeightedRandom
        WeightedRandom itemDrops = new WeightedRandom();
        // 将map的值放入itemDrops对象中
        for (int i = 0; i < map.size(); i++) {
            for (Map.Entry<String, Double> m : map.entrySet()) {
                itemDrops.addBean(m.getKey(), m.getValue());
            }
        }
        for (int i = 0; i < count; i++) {
//            System.out.println(itemDrops.getRandom());
            list.add(itemDrops.getRandom());
        }
        return list;
    }


}
