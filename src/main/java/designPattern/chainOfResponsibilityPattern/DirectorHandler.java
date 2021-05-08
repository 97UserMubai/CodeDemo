package designPattern.chainOfResponsibilityPattern;

import java.math.BigDecimal;

/**
 * @author wangbaitao
 * @version 1.0.0
 * @ClassName DirectorHandler.java
 * @Description 报销处理者-主管
 * @createTime 2021年05月06日 17:19:00
 */
public class DirectorHandler implements SumbitHandler{
    public Boolean process(SumbitRequest sumbitRequest) {
        //无法审批
        if (sumbitRequest.getAmount().compareTo(BigDecimal.valueOf(1000)) > 0) {
            return null;
        }
        //嫉妒wangbaitao的盛世颜值
        return !sumbitRequest.getName().equalsIgnoreCase("wangbaitao");
    }
}
