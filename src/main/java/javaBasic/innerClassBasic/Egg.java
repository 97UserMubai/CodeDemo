package javaBasic.innerClassBasic;

/**
 * @Classname Egg
 * @Description
 * @Date 2021/11/14 12:30
 * @Created by mubai
 */
public class Egg {

    protected class Yolk{
        public Yolk(){
            System.out.println("父类内部类初始化");
        }
        public void f(){
            System.out.println("父类内部类方法被调用");
        }
    }
    private Yolk y = new Yolk();
    public Egg(){
        System.out.println("父类被初始化");
    }
    public void insertYolk(Yolk yy){
        y = yy;
    }
    public void g(){
        y.f();
    }
}
