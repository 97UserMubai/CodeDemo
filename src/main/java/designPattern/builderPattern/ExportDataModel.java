package designPattern.builderPattern;

import lombok.Builder;
import lombok.Data;

/**
 * @author wangbaitao
 * @version 1.0.0
 * <h>文件体部分，输出数据部分</h>
 * @Date 2021/4/29
 **/
@Data
@Builder
public class ExportDataModel {
    //产品id
    private String productId;
    //价格
    private Double price;
    //销量
    private Double amount;
}
