package designPattern;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import excel.ExcelTestEntity;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

/**
 * @author by mubai
 * @Classname EasypoiTest
 * @Description
 * @Date 2021/8/7 10:51
 */
public class EasypoiTest {
    @Test
    public void dynaCol() {
        List<ExcelTestEntity> entities = new ArrayList<>();
        //第一层
        ExcelTestEntity zongbu = new ExcelTestEntity("10001", "总部", 1);
        List<ExcelTestEntity> childrenLevel2 = new ArrayList<>();
        ExcelTestEntity shenghuoqu = new ExcelTestEntity("10002", "生活区", 2);
        List<ExcelTestEntity> childrenLevel3 = new ArrayList<>();
        ExcelTestEntity ABuild = new ExcelTestEntity("10004", "A座", 3);
        List<ExcelTestEntity> childrenLevel4 = new ArrayList<>();
        ExcelTestEntity floor2 = new ExcelTestEntity("10006", "2层", 4);
        ExcelTestEntity floor3 = new ExcelTestEntity("10007", "3层", 4);
        List<ExcelTestEntity> childrenLevel5 = new ArrayList<>();
        ExcelTestEntity room301 = new ExcelTestEntity("10010", "301", 5);
        ExcelTestEntity room302 = new ExcelTestEntity("10011", "302", 5);
        childrenLevel5.add(room301);
        childrenLevel5.add(room302);
        floor3.setChildren(childrenLevel5);
        childrenLevel4.add(floor2);
        childrenLevel4.add(floor3);
        ABuild.setChildren(childrenLevel4);
        ExcelTestEntity BBuild = new ExcelTestEntity("10005", "B座", 3);
        List<ExcelTestEntity> childrenLevel41 = new ArrayList<>();
        ExcelTestEntity floor4 = new ExcelTestEntity("10008", "4层", 4);
        ExcelTestEntity floor5 = new ExcelTestEntity("10009", "5层", 4);
        childrenLevel41.add(floor4);
        childrenLevel41.add(floor5);
        BBuild.setChildren(childrenLevel41);
        childrenLevel3.add(ABuild);
        childrenLevel3.add(BBuild);
        shenghuoqu.setChildren(childrenLevel3);
        ExcelTestEntity gongzuoqu = new ExcelTestEntity("10003", "商业区", 2);
        childrenLevel2.add(shenghuoqu);
        childrenLevel2.add(gongzuoqu);
        zongbu.setChildren(childrenLevel2);
        entities.add(zongbu);

        try {
            List<ExcelExportEntity> colList = new ArrayList<>();
            ExcelExportEntity colEntity = new ExcelExportEntity("ID", "id");
            colEntity.setNeedMerge(false);
            colList.add(colEntity);

            //获取最高层级
            entities.forEach(entity -> dealHeaderList(entity, colList));

            //进行行内容加工
            List<Map<String, Object>> list = new ArrayList<>();
            entities.forEach(entity -> dealResultMap(entity, list));

            Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(), colList,
                    list);
            FileOutputStream fos = new FileOutputStream("D:/树结构.xls");
            workbook.write(fos);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 递归处理导出excel的map数据
     */
    private void dealResultMap(ExcelTestEntity entity, List<Map<String, Object>> list) {
        //先处理默认第一层
        Map<String, Object> valMap = new HashMap<>();
        valMap.put("id", entity.getId());
        valMap.put("level" + entity.getLevel(), entity.getName());
        list.add(valMap);
        if (Objects.nonNull(entity.getChildren()) && !entity.getChildren().isEmpty()) {
            entity.getChildren().forEach(children -> dealResultMap(children, list));
        }
    }

    private void dealHeaderList(ExcelTestEntity entity, List<ExcelExportEntity> colList) {
        ExcelExportEntity col = new ExcelExportEntity("第" + entity.getLevel() + "层", "level" + entity.getLevel());
        col.setNeedMerge(true);
        if (!colList.contains(col)) {
            colList.add(col);
        }
        if (Objects.nonNull(entity.getChildren()) && !entity.getChildren().isEmpty()) {
            entity.getChildren().forEach(children -> dealHeaderList(children, colList));
        }
    }
}
