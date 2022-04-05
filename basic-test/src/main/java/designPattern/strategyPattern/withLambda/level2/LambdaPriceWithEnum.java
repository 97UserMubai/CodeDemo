package designPattern.strategyPattern.withLambda.level2;

/**
 * @Classname LambdaPriceWithEnum
 * @Description TODO
 * @Date 2022-4-5 13:59
 * @Created by mubai
 */
public class LambdaPriceWithEnum {
    private StrategyEnum strategy;

    public LambdaPriceWithEnum(StrategyEnum strategy) {
        this.strategy = strategy;
    }

    public double quote(double booksPrice, double discount) {
        return this.strategy.getStrategy().apply(booksPrice, discount);
    }
}
