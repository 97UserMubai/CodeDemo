package excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import lombok.Data;

import java.util.List;

/**
 * @Classname ImportTestLevel2
 * @Description TODO
 * @Date 2022-6-19 20:35
 * @Created by mubai
 */
@Data
public class ImportTestLevel2 {

    @Excel(name = "班级编号",orderNum = "0")
    private String classCode;

    @Excel(name = "班级名称",orderNum = "1")
    private String className;

    @ExcelCollection(name = "第三层",orderNum = "2")
    private List<ImportTestLevel3> testLevel3s;

}
