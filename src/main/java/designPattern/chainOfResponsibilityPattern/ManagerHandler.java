package designPattern.chainOfResponsibilityPattern;

import java.math.BigDecimal;

/**
 * @author wangbaitao
 * @version 1.0.0
 * @ClassName ManagerHandler.java
 * @Description 报销处理者-经理
 * @createTime 2021年05月06日 17:17:00
 */
public class ManagerHandler implements SumbitHandler {
    public Boolean process(SumbitRequest sumbitRequest) {
        //无法审批
        if (sumbitRequest.getAmount().compareTo(BigDecimal.valueOf(100)) > 0) {
            return null;
        }
        //对wangbaitao情有独钟
        return sumbitRequest.getName().equalsIgnoreCase("wangbaitao");
    }
}
