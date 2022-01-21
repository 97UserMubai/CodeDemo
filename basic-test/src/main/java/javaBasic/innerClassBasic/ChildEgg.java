package javaBasic.innerClassBasic;

/**
 * @Classname ChildEgg
 * @Description
 * @Date 2021/11/14 12:34
 * @Created by mubai
 */
public class ChildEgg extends Egg{
    public class Yolk extends Egg.Yolk{
        public Yolk(){
            System.out.println("子类继承的内部类被初始化");
        }
        public void f() {
            System.out.println("子类继承的内部类方法被调用");
        }
    }
    public ChildEgg(){
        insertYolk(new Yolk());
    }
    /**
     * 下面的执行方法中，包含以下知识点：
     * 首先这里因为继承，会调用父类的构造器，父类构造器中包含一个全局变量的内部类对象，所以执行顺序是
     * 父类内部类构造器执行->父类构造器执行->子类构造器执行
     * 子类构造器中调用了父类的的insertYolk方法，该方法传了一个当前内部类对象，并且是被new出来的，所以这个位置的执行顺序是：
     * 父类内部类构造器执行->子类内部类构造被执行
     * 再看看InsertYolk方法，执行了一个f()方法，该方法因为动态加载获得的是子类内部类的句柄，所以调用的是子类继承的f()
     * 输出结果：
     * 父类内部类初始化
     * 父类被初始化
     * 父类内部类初始化
     * 子类继承的内部类被初始化
     * 子类继承的内部类方法被调用
     */
    public static void main(String[] args) {
        Egg egg = new ChildEgg();
        egg.g();
    }
}
