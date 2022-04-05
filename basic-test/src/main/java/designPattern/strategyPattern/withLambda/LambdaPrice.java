package designPattern.strategyPattern.withLambda;

import java.util.function.BinaryOperator;

/**
 * @Classname LambdaPrice
 * @Description TODO
 * @Date 2022-4-5 13:39
 * @Created by mubai
 */
public class LambdaPrice {
    private BinaryOperator<Double> strategy;
    public LambdaPrice(BinaryOperator<Double> strategy) {
        this.strategy = strategy;
    }
    public double quote(double booksPrice, double discount) {
        return this.strategy.apply(booksPrice, discount);
    }
}
