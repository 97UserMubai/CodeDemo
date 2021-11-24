package javaBasic.arrayBasic;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @Classname VectorTypeTest
 * @Description
 * @Date 2021/11/21 11:41
 * @Created by mubai
 */
public class VectorTypeTest {

    static class Dog {
        private int dogNumber;

        Dog(int i) {
            dogNumber = i;
        }

        void print() {
            System.out.println("Dog#" + dogNumber);
        }
    }

    static class Cat {
        private int catNumber;

        Cat(int i) {
            catNumber = i;
        }

        void print() {
            System.out.println("Cat#" + catNumber);
        }
    }

    /**
     * 这个位置体现的知识点：
     * 1、Java集合类在不指定class类型的时候，可以随意的insert任意Object
     * 2、当发生类似于vecotr.elementAt获取Object进行强转的情况时就会发生运行时的错误：ClassCastException
     * 3、elements方法会获得一个Enumration对象，该对象Iterator有点像，属于轻量级对象并且使用时获取的是原来集合对象元素的句柄.369
     */
    public static void main(String[] args) {
        Vector cats = new Vector();
        for (int i = 1; i <= 7; i++) {
            cats.addElement(new Cat(i));
        }
        cats.addElement(new Dog(8));
        for (int i = 0; i < cats.size(); i++) {
            System.out.println(cats.elementAt(i));
        }
        System.out.println("使用elements方法获取枚举集合");
        Enumeration elements = cats.elements();
        while (elements.hasMoreElements()) {
            System.out.println(elements.nextElement());
        }
        System.out.println("下面测试运行时cast异常");
        for (int i = 0; i < cats.size(); i++) {
            ((Cat) cats.elementAt(i)).print();
        }
    }
}
