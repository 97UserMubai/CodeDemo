package designPattern.chainOfResponsibilityPattern;

/**
 * @author wangbaitao
 * @version 1.0.0
 * @ClassName CEOHandler.java
 * @Description 报销处理者-CEO
 * @createTime 2021年05月06日 17:20:00
 */
public class CEOHandler implements SumbitHandler {
    public Boolean process(SumbitRequest sumbitRequest) {
        return true;
    }
}
