package designPattern.singletonPattern;

/**
 * @author wangbaitao
 * @version 1.0.0
 * <h>单例模式代码测试案例</h>
 * @Date 2021/4/27
 **/
public class SingletonTest {
    private String name = null;

    private Integer code = 0;

    private SingletonTest() {
    }

    private static volatile SingletonTest single = null;

    public static SingletonTest getInstanceNoSafe() {
        if (single == null) {
            single = new SingletonTest();
        }
        return single;
    }

    public static synchronized SingletonTest getInstanceSafeOne() {
        if (single == null) {
            single = new SingletonTest();
        }
        return single;
    }

    public static SingletonTest getInstanceSafeTwo() {
        if (single == null) {
            synchronized (SingletonTest.class) {
                if (single == null) {
                    single = new SingletonTest();
                }
            }
        }
        return single;
    }

    private static class SingletonTestHolder {
        private static final SingletonTest INSTANCE = new SingletonTest();
    }

    public static final SingletonTest getInstanceSafeThree() {
        return SingletonTestHolder.INSTANCE;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void printInfo() {
        System.out.println("the name is " + name);
    }

    public void printCode() {
        System.out.println("the code is " + code);
    }
}
