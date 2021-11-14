package javaBasic.constructorBasic;

/**
 * @Classname Child
 * @Description
 * @Date 2021/11/14 17:25
 * @Created by mubai
 */
public class Child extends InnerAndConstructorTest{
    Child(){
        System.out.println("子类 构造器");
    }

    /**
     * 输出结果：
     * 父类 inner 构造器
     * 父类 构造器
     * 子类 构造器
     */
    public static void main(String[] args) {
        Child child = new Child();
    }
}
