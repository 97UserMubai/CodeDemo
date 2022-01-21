package designPattern.strategyPattern;

/**
 * @Classname LowMemberStrategy
 * @Description 初级会员具体策略类
 * @Date 2021/5/24 16:36
 * @Created by mubai
 */
public class LowMemberStrategy extends MemberStrategy {
    @Override
    public double calcPrice(double booksPrice) {
        System.out.println("初级会员没有折扣");
        return booksPrice;
    }
}
