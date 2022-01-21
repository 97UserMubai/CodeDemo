package designPattern.strategyPattern;

/**
 * @Classname MiddleMemberStrategy
 * @Description 中级会员策略
 * @Date 2021/5/24 16:37
 * @Created by mubai
 */
public class MiddleMemberStrategy extends MemberStrategy {
    @Override
    public double calcPrice(double booksPrice) {
        System.out.println("中级会员享受九折优惠");
        return booksPrice * 0.9;
    }
}
