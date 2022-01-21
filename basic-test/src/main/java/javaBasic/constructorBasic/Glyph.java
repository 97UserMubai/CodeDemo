package javaBasic.constructorBasic;

/**
 * @Classname MethodAndConstructorTest
 * @Description
 * @Date 2021/11/14 17:33
 * @Created by mubai
 */
abstract public class Glyph {
    abstract void draw();
    Glyph(){
        System.out.println("父类构造器初始化开始");
        draw();
        System.out.println("父类构造初始化结束");
    }
}
