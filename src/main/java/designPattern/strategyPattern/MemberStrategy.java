package designPattern.strategyPattern;

/**
 * @Classname MemberStrategy
 * @Description 会员抽象类
 * @Date 2021/5/24 16:35
 * @Created by mubai
 */
public abstract class MemberStrategy {

    /**
     * 抽象接口-计算价格
     *
     * @param booksPrice 原价
     * @return 计算后的价格
     */
    public abstract double calcPrice(double booksPrice);

}
