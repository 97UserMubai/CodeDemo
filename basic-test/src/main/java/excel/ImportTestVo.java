package excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import lombok.Data;

import java.util.List;

/**
 * @Classname ImportTestVo
 * @Description TODO
 * @Date 2022-6-19 20:34
 * @Created by mubai
 */
@Data
public class ImportTestVo {
    @Excel(name = "序号", orderNum = "0")
    private String index;
    @Excel(name = "名称", orderNum = "1")
    private String name;
    @Excel(name = "年纪", orderNum = "2")
    private String age;

    @ExcelCollection(name = "第二层", orderNum = "3")
    private List<ImportTestLevel2> level2List;
}
