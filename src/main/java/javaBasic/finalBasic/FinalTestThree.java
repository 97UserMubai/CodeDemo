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
        /*输出了helloword,我们观察一下MyClass3.changeValue方法，参数使用了final来修饰，这样是为了保证入参的buffer不被修改指向,但是内容是可以变化的
        * 这样的作用是，在myClass3.changeValue(stringBuffer)方法运行过程中保证入参对象的引用不会被修改地址*/
        System.out.println(stringBuffer.toString());
        MyClass4 myClass4 = new MyClass4();
        myClass4.changeValue(stringBuffer);
        /*输出了helloword，我们再观察一下MyClass4.changeValue方法，发现不使用final关键字来修饰引用类型的情况下，
        形参的变化并不影响实参的引用，所以方法参数的传递是值传递*/
        System.out.println(stringBuffer.toString());
        MyClass5 myClass5 = new MyClass5();
        /*输出了hahahaha：wang，但是这部分代码跟当前测试案例没有太多的关系，方法形参尽管被重新赋值，但是实参并不会被修改，
        该changeValue方法相当于重新创建了一个引用对象，这里建立的新对象需要进行=的赋值才能修改原来参数的引用*/
        //todo 这个位置的知识点在于，一个入参的对象，尽管return了，但是没有通过=进行赋值的话，原本入参的对象并不会修改自己的引用
        System.out.println(myClass5.changeValue(stringBuffer).toString());
        /*输出了helloword*/
        /*总结：方法的形参发生任何变化并不会对实参有指向性的修改，所以不需要使用final来修饰*/
        System.out.println(stringBuffer.toString());
    }

}

class MyClass3 {
    void changeValue(final StringBuffer buffer) {
        //这里会提示报错 buffer = new StringBuffer("22222");
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
        //因为没有使用final修饰参数，所以这个位置可以改变buffer的引用
        buffer = new StringBuffer("hahahaha");
        buffer.append("：wang");
        return buffer;
    }
}
