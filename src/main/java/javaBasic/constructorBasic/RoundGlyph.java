package javaBasic.constructorBasic;

/**
 * @Classname RoundGlyph
 * @Description
 * @Date 2021/11/14 17:35
 * @Created by mubai
 */
public class RoundGlyph extends Glyph{
    int radius = 1;

    RoundGlyph(int i){
        radius = i;
        System.out.println("子类初始化完成，当前radius值为："+radius);
    }

    @Override
    void draw() {
        System.out.println("当前的初始化的变量radius值为:"+radius);
    }

    /**
     * 输出结果：
     * 父类构造器初始化开始
     * 当前的初始化的变量radius值为:0
     * 父类构造初始化结束
     * 子类初始化完成，当前radius值为：5
     * 知识点：构造器的多态性在抽象类的动态绑定方法时，对于需要初始化的变量，会按照Java的规范进行基础变量默认值的设定
     * 对于构造器初始来说，要尽量变量调用方法，构造器内唯一能够安全调用的只有final修饰的变量和方法
     */
    public static void main(String[] args) {
        new RoundGlyph(5);
    }
}
