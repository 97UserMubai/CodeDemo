package javaBasic.innerClassBasic;

/**
 * @Classname InnerInitTest
 * @Description 内部类初始化测试
 * @Date 2021/11/14 12:46
 * @Created by mubai
 */
public class InnerInit {
    public class Inner{
        public Inner(){
            System.out.println("内部类 init");
        }
    }
    public InnerInit(){
        System.out.println("外部类初始化");
    }

    private Inner inner = new Inner();

    public void p(){
        System.out.println("断点测试");
    }

    /**
     * 当内部类被定义成全局变量的时候，初始化的过程是：
     * 内部类构造->外部类构造->外部类方法
     * @param args
     */
    public static void main(String[] args) {
        InnerInit innerInit = new InnerInit();
        innerInit.p();
    }
}
