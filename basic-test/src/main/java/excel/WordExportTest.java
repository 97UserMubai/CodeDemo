package excel;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.afterturn.easypoi.word.WordExportUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname WordExportTest
 * @Description TODO
 * @Date 2022-5-9 22:19
 * @Created by mubai
 */
public class WordExportTest {

    public static void main(String[] args) throws Exception {
        Map<String,  List<Map<String, Object>>> value = new HashMap<>();
        List<Map<String, Object>> colList = new ArrayList<Map<String, Object>>();
        //先处理表头
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "小明挑战");
        map.put("zq", "正确");
        map.put("cw", "错误");
        map.put("tj", "统计");
        map.put("zqmk", "t.zq_xm");
        map.put("cwmk", "t.cw_xm");
        map.put("tjmk", "t.tj_xm");
        colList.add(map);

        map = new HashMap<String, Object>();
        map.put("name", "小红挑战");
        map.put("zq", "正确");
        map.put("cw", "错误");
        map.put("tj", "统计");
        map.put("zqmk", "n:t.zq_xh");
        map.put("cwmk", "n:t.cw_xh");
        map.put("tjmk", "n:t.tj_xh");
        colList.add(map);

        value.put("colList", colList);

        List<Map<String, Object>> valList = new ArrayList<Map<String, Object>>();
        map = new HashMap<String, Object>();
        map.put("one", "运动");
        map.put("two", "跑步");
        map.put("zq_xm", 1);
        map.put("cw_xm", 2);
        map.put("tj_xm", 3);
        map.put("zq_xh", 4);
        map.put("cw_xh", 2);
        map.put("tj_xh", 6);
        valList.add(map);
        map = new HashMap<String, Object>();
        map.put("one", "运动");
        map.put("two", "跳高");
        map.put("zq_xm", 1);
        map.put("cw_xm", 2);
        map.put("tj_xm", 3);
        map.put("zq_xh", 4);
        map.put("cw_xh", 2);
        map.put("tj_xh", 6);
        valList.add(map);
        map = new HashMap<String, Object>();
        map.put("one", "文化");
        map.put("two", "数学");
        map.put("zq_xm", 1);
        map.put("cw_xm", 2);
        map.put("tj_xm", 3);
        map.put("zq_xh", 4);
        map.put("cw_xh", 2);
        map.put("tj_xh", 6);
        valList.add(map);

        value.put("valList", valList);
        XWPFDocument word = WordExportUtil.exportWord07("D:\\projects\\basic-test\\src\\main\\resources\\template\\test_tem.docx", colList);
        FileOutputStream fos = new FileOutputStream("D:/ExcelExportTemplateColFeTest_one.docx");
        word.write(fos);
        fos.close();
//        TemplateExportParams params = new TemplateExportParams("D:\\projects\\basic-test\\src\\main\\resources\\template\\test.xls");
//        /**
//         * 这里就是大坑所在！！记得这值设置为true,文档并未说明
//         */
//        params.setColForEach(true);
//        Workbook book = ExcelExportUtil.exportExcel(params, value);
//        //PoiMergeCellUtil.mergeCells(book.getSheetAt(0), 1, 0,1);
//        FileOutputStream fos = new FileOutputStream("D:/ExcelExportTemplateColFeTest_one.xls");
//        book.write(fos);
//        fos.close();
    }
}
