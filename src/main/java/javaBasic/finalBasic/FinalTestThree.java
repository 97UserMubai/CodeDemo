package javaBasic.finalBasic;

/**
 * @Classname FinalTestThree
 * @Description
 * @Date 2021/5/14 16:48
 * @Created by mubai
 */
public class FinalTestThree {

    public static void main(String[] args) {
        MyClass3 myClass3 = new MyClass3();
        StringBuffer stringBuffer = new StringBuffer("hello");
        myClass3.changeValue(stringBuffer);
        /*输出了helloword,我们观察一下MyClass3.changeValue方法，参数使用了final来修饰，这样是为了保证入参的buffer不被修改指向*/
        System.out.println(stringBuffer.toString());
        MyClass4 myClass4 = new MyClass4();
        myClass4.changeValue(stringBuffer);
        /*输出了helloword，我们再观察一下MyClass4.changeValue方法，发现不使用final关键字来修饰引用类型的情况下，
        形参的变化并不影响实参的引用，所以方法参数的传递是值传递*/
        System.out.println(stringBuffer.toString());
        MyClass5 myClass5 = new MyClass5();
        /*输出了hahahaha：wang，但是这部分代码跟当前测试案例没有太多的关系，方法形参尽管被重新赋值，但是实参并不会被修改，
        该changeValue方法相当于重新创建了一个引用对象*/
        System.out.println(myClass5.changeValue(stringBuffer).toString());
        /*输出了helloword*/
        /*总结：方法的形参发生任何变化并不会对实参有指向性的修改，所以不需要使用final来修饰*/
        System.out.println(stringBuffer.toString());
    }

}

class MyClass3 {
    void changeValue(final StringBuffer buffer) {
        buffer.append("word");
    }
}

class MyClass4 {
    void changeValue(StringBuffer buffer) {
        buffer = new StringBuffer("hahahaha");
        buffer.append("：wang");
    }
}

class MyClass5 {
    StringBuffer changeValue(StringBuffer buffer) {
        buffer = new StringBuffer("hahahaha");
        buffer.append("：wang");
        return buffer;
    }
}
