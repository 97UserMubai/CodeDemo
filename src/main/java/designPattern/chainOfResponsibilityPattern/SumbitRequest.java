package designPattern.chainOfResponsibilityPattern;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author wangbaitao
 * @version 1.0.0
 * @ClassName SumbitRequest.java
 * @Description 责任链模式的测试实体，其中name用于特殊判断，amount作为传递的判断调价按
 * @createTime 2021年05月06日 16:56:00
 */
@Data
@Builder
public class SumbitRequest {
    //姓名
    private String name;
    //报销金额
    private BigDecimal amount;

    @Override
    public String toString() {
        return "SumbitRequest{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }
}
