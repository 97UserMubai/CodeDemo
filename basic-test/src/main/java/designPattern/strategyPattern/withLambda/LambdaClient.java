package designPattern.strategyPattern.withLambda;

/**
 * @Classname LambdaClient
 * @Description TODO
 * @Date 2022-4-5 13:43
 * @Created by mubai
 */
public class LambdaClient {
    public static void main(String[] args) {
        LambdaPrice lambdaPrice;
        double bookPrice = 300.0;
        lambdaPrice = new LambdaPrice((v1, v2) -> v1 * v2);
        System.out.println("打了五折:" + lambdaPrice.quote(bookPrice, 0.5));
        lambdaPrice = new LambdaPrice((v1, v2) -> v1 - v2);
        System.out.println("满减20:" + lambdaPrice.quote(bookPrice, 20.0));
    }
}
