package designPattern.singletonPattern;

/**
 * @author wangbaitao
 * @version 1.0.0
 * <h>懒汉单例模式的代码</h>
 * <pre>
 *    单例模式有以下特点：
 * 　　1、单例类只能有一个实例。
 * 　　2、单例类必须自己创建自己的唯一实例。
 * 　　3、单例类必须给所有其他对象提供这一实例。
 * 　　单例模式确保某个类只有一个实例，而且自行实例化并向整个系统提供这个实例。
 *    在计算机系统中，线程池、缓存、日志对象、对话框、打印机、显卡的驱动程序对象常被设计成单例。
 *    这些应用都或多或少具有资源管理器的功能。每台计算机可以有若干个打印机，但只能有一个Printer Spooler，
 *    以避免两个打印作业同时输出到打印机中。
 *    每台计算机可以有若干通信端口，系统应当集中管理这些通信端口，以避免一个通信端口同时被两个请求同时调用。
 *    总之，选择单例模式就是为了避免不一致状态，避免政出多头。
 * </pre>
 * @Date 2021/4/27
 **/
public class Singleton {
    /**
     * 使用private修饰的构造方法，屏蔽外部类直接使用构造器进行对象的实例化
     */
    private Singleton() {
    }

    /**
     * 知识点：
     * ①使用static关键字表明这是一个共享的变量
     * 正常访问一个类的对象有两种方式：①new Object.xx ②Object.xx（static）
     * 在单例模式中，构造器是对外部屏蔽的，所以必须使用static来获取
     * ②初值为null，在类加载的时候并不占用内存，只有在第一次使用的时候才会进行初始化，所以是懒汉式
     * ③使用volatile关键字避免在双重检查的案例中因为指令重排序让其在判断的时候出现不同线程判断不一致的情况
     * PS:因为先判空再使用synchronized,所以外层的判空操作可能会因为指令重排序而失效
     */
    private static volatile Singleton single = null;

    /**
     * 线程不安全的懒汉式单例获取方法
     * PS:在不同线程同时调用getInstance的时候会出现对象不一样的情况。
     */
    public static Singleton getInstanceNoSafe() {
        if (single == null) {
            single = new Singleton();
        }
        return single;
    }

    /**
     * 最粗暴的线程安全的单例获取方法
     * 在上面那个代码中加上synchronized关键字修饰，在每次获取单例实体之前进行代码同步
     * 但是在实际应用场景中99%不需要进行同步，所以这个会有很大的效率问题
     */
    public static synchronized Singleton getInstanceSafeOne() {
        if (single == null) {
            single = new Singleton();
        }
        return single;
    }


    /**
     * 双重检查锁定，因为99%场景中单例对象并不会为空，所以效率会比上面那种高很多
     */
    public static Singleton getInstanceSafeTwo() {
        if (single == null) {
            synchronized (Singleton.class) {
                if (single == null) {
                    single = new Singleton();
                }
            }
        }
        return single;
    }

    /**
     * 饿汉模式中，在对象加载的时候就会直接进行内存分配，但是程序并不一定会对该对象进行使用
     * 所以饿汉模式会造成一定程度的浪费，但是饿汉模式有个好处是其在加载的时候利用ClassLoader的机制，保证了其是单线程的
     * 所以饿汉模式天生就是线程安全的
     * -------------------------
     * 这里利用ClassLoader机制+静态内部类的机制来实现线程安全，并且让内存不浪费
     * ①ClassLoader加载单线程
     * ②静态内部类只有在被使用的时候才会被初始化
     */
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstanceSafeThree() {
        return SingletonHolder.INSTANCE;
    }

    //下面是饿汉单例模式，代码会简单很多
//    private static final Singleton single = new Singleton();
//
//    public static Singleton getInstance() {
//        return single;
//    }
}
