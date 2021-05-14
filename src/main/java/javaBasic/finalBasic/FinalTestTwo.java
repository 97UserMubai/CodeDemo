package javaBasic.finalBasic;

/**
 * @Classname FinalTestTwo
 * @Description
 * @Date 2021/5/14 15:19
 * @Created by mubai
 */
public class FinalTestTwo {
    public static void main(String[] args) {
        final MyClass myClass = new MyClass();
        //输出结果为1，所以使用final修饰的对象，其不可改的是他的引用地址，其对象内容是可以修改的
        System.out.println(++myClass.i);

        MyClass2 myClass2 = new MyClass2();
        MyClass2 myClass3 = new MyClass2();
        /*
         * 根据结果会发现使用final修饰的变量内容，在每次调用的时候仍然会重新赋值，
         * 使用static修饰的关键字则会直接使用class在初始化时便赋予的值，这个值是不变的
         */
        //0.7390623568878272
        System.out.println(myClass2.i);
        //0.20015214109235024
        System.out.println(myClass2.j);
        //0.7162615955285724
        System.out.println(myClass3.i);
        //0.20015214109235024
        System.out.println(myClass3.j);
    }
}

class MyClass {
    public int i = 0;
}

class MyClass2 {
    public final double i = Math.random();
    public static double j = Math.random();
}
