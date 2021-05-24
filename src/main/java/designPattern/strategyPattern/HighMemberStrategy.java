package designPattern.strategyPattern;

/**
 * @Classname HighMemberStrategy
 * @Description 高级会员策略
 * @Date 2021/5/24 16:38
 * @Created by mubai
 */
public class HighMemberStrategy extends MemberStrategy {
    @Override
    public double calcPrice(double booksPrice) {
        System.out.println("高级会员享受八折优惠");
        return booksPrice * 0.8;
    }
}
