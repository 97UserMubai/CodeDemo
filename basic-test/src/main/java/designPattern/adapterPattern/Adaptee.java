package designPattern.adapterPattern;

/**
 * @Classname Adaptee
 * @Description 适配者类
 * @Date 2022-4-3 22:55
 * @Created by mubai
 */
public class Adaptee {

    public void adjustRequest() {
        System.out.println("适配者中的业务代码被执行");
    }

}
