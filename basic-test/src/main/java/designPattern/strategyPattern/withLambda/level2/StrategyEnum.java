package designPattern.strategyPattern.withLambda.level2;

import java.util.function.BinaryOperator;

/**
 * @Classname StrategyEnum
 * @Description TODO
 * @Date 2022-4-5 13:55
 * @Created by mubai
 */
public enum StrategyEnum {
    DISCOUNT((v1, v2) -> v1 * v2, "折扣"),
    FULL_REDUCTION((v1, v2) -> v1 - v2, "满减");

    private BinaryOperator<Double> strategy;
    private String desc;


    StrategyEnum(BinaryOperator<Double> strategy, String desc) {
        this.strategy = strategy;
        this.desc = desc;
    }

    public BinaryOperator<Double> getStrategy() {
        return strategy;
    }
}
