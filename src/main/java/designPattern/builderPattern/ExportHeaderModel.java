package designPattern.builderPattern;

import lombok.Data;

/**
 * @author wangbaitao
 * @version 1.0.0
 * <h>文件头导出model</h>
 * @Date 2021/4/29
 **/
@Data
public class ExportHeaderModel {
    //公司编号
    private String depId;
    //导出数据的日期
    private String exportDate;
}
