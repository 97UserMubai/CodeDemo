package javaBasic.constructorBasic;

/**
 * @Classname InnerAndConstructorTest
 * @Description
 * @Date 2021/11/14 17:24
 * @Created by mubai
 */
public class InnerAndConstructorTest {
    class Inner{
        Inner(){
            System.out.println("父类 inner 构造器");
        }
    }
    private Inner inner= new Inner();
    InnerAndConstructorTest(){
        System.out.println("父类 构造器");
    }
}
