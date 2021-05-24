package designPattern.strategyPattern;

/**
 * @Classname Price
 * @Description
 * @Date 2021/5/24 16:39
 * @Created by mubai
 */
public class Price {
    //策略
    private MemberStrategy memberStrategy;

    //通过构造器进行策略的注入
    public Price(MemberStrategy memberStrategy) {
        this.memberStrategy = memberStrategy;
    }

    public void setMemberStrategy(MemberStrategy memberStrategy) {
        this.memberStrategy = memberStrategy;
    }

    //调用策略算法进行最终价格的计算
    public double quote(double booksPrice){
        return this.memberStrategy.calcPrice(booksPrice);
    }
}
