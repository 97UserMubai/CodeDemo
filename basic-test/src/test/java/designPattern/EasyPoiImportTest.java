package designPattern;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import excel.ImportTestLevel2;
import excel.ImportTestLevel3;
import excel.ImportTestVo;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Classname EasyiPoiImportTest
 * @Description TODO
 * @Date 2022-6-19 20:48
 * @Created by mubai
 */
public class EasyPoiImportTest {

    @Test
    public void testExport() throws IOException {
        ImportTestVo importTestVo = new ImportTestVo();
        importTestVo.setIndex("1");
        importTestVo.setName("小王");
        importTestVo.setAge("18");
        ImportTestLevel2 importTestLevel2 = new ImportTestLevel2();
        importTestLevel2.setClassCode("班级编号001");
        importTestLevel2.setClassName("班级名称");
        ImportTestLevel3 importTestLevel3 = new ImportTestLevel3();
        importTestLevel3.setItemCode("项目编号001");
        importTestLevel3.setItemName("项目名称");
        importTestLevel3.setItemValue("1223");
        List<ImportTestLevel3> importTestLevel3s = new ArrayList<>();
        importTestLevel3s.add(importTestLevel3);
        importTestLevel2.setTestLevel3s(importTestLevel3s);
        List<ImportTestLevel2> importTestLevel2s = new ArrayList<>();
        importTestLevel2s.add(importTestLevel2);
        importTestVo.setLevel2List(importTestLevel2s);
        List<ImportTestVo> list = new ArrayList<>();
        list.add(importTestVo);
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(), ImportTestVo.class, list);
        FileOutputStream fos = new FileOutputStream("C:\\Users\\16103\\Desktop\\export\\test.xls");
        workbook.write(fos);
        fos.close();
    }

    @Test
    public void testImport() throws Exception {
        ImportParams params = new ImportParams();
        params.setHeadRows(3);
        File file = new File("C:\\Users\\16103\\Desktop\\export\\test.xls");
        List<ImportTestVo> list = ExcelImportUtil.importExcel(new FileInputStream(file), ImportTestVo.class, params);
//        List<Map<String, Object>> list = ExcelImportUtil.importExcel(new FileInputStream(file), Map.class, params);
        System.out.println("debug");
    }

}
