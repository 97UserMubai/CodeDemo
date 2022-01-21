package javaBasic.finalBasic;

/**
 * @Classname FinalTestOne
 * @Description 测试final修饰的变量和普通变量有什么区别
 * @Date 2021/5/14 14:44
 * @Created by mubai
 */
public class FinalTestOne {
    public static void main(String[] args) {
        String a = "hello2";
        final String b = "hello";
        String c = "hello";
        //false
        System.out.println(a == c);
        String d = b + 2;
        String e = c + 2;
        String f = getHello();
        String g = f + 2;
        /*true,这里我们观察一下d=b+2，而b的定义为final String b = "hello"，这里的知识点是：
        * 当final变量是基本数据类型以及String类型时，如果在编译器就能知道它的值，那么编译器会将该值当作编译期常量使用，
        * 也就是说运行时访问该final变量的地方，相当于访问该常量
        * 那么在使用到b时，会直接替换成常量
        * */
        System.out.println(a == d);
        /*
        * false，这里主要是final修饰的变量进行比较，在没有final修饰的变量在被访问时需要在运行时通过链接来进行，所以这里为false
        * */
        System.out.println(a == e);
        /*f
        alse，仔细观察g=f，来自一个静态方法getHello()，并不属于基本数据类型和String类型，所以这里在运行时被访问也是通过链接来实现
        * */
        System.out.println(a == g);
        /*
        true，这里复习一下== 和 equals的比较
        == ： 基础数据类型比较的是值，引用类型比较的是堆地址
        equals : 默认的Object比较的是堆地址，在String类中进行了重写，会根据char[]数据遍历来比较是否相等(相互于值比较)
        * */
        System.out.println(a.equals(d));
        //true
        System.out.println(a.equals(e));

        String h = "hello2";
        /*true，字符串常量池直接将a的地址给了h，所以两者是相等的*/
        System.out.println(a == h);
        String i = new String("hello2");
        //false
        System.out.println(a == i);
    }

    public static String getHello() {
        return "hello";
    }
}
