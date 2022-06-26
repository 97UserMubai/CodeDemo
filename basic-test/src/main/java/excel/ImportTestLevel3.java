package excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

/**
 * @Classname ImportTestLevel3
 * @Description TODO
 * @Date 2022-6-19 20:36
 * @Created by mubai
 */
@Data
public class ImportTestLevel3 {

    @Excel(name = "项目编号", orderNum = "0")
    private String itemCode;

    @Excel(name = "项目名称", orderNum = "1")
    private String itemName;

    @Excel(name = "项目值", orderNum = "2")
    private String itemValue;
}
