package designPattern.strategyPattern.withLambda.level2;

/**
 * @Classname LambdaClientWithEnum
 * @Description TODO
 * @Date 2022-4-5 14:00
 * @Created by mubai
 */
public class LambdaClientWithEnum {
    public static void main(String[] args) {
        double bookPrice = 300.0;
        System.out.println("打了五折："+new LambdaPriceWithEnum(StrategyEnum.DISCOUNT).quote(bookPrice,0.5));
        System.out.println("满减20："+new LambdaPriceWithEnum(StrategyEnum.FULL_REDUCTION).quote(bookPrice,20));
    }
}
