package designPattern.strategyPattern;

/**
 * @Classname Client
 * @Description 客户端
 * @Date 2021/5/24 16:41
 * @Created by mubai
 */
public class Client {
    public static void main(String[] args) {
        MemberStrategy strategy = new LowMemberStrategy();
        //创建Price对象
        Price price = new Price(strategy);
        System.out.println("最终图书价格为:" + price.quote(300.0));
        price.setMemberStrategy(new MiddleMemberStrategy());
        System.out.println("最终图书价格为:" + price.quote(300.0));
        price.setMemberStrategy(new HighMemberStrategy());
        System.out.println("最终图书价格为:" + price.quote(300.0));
    }
}
