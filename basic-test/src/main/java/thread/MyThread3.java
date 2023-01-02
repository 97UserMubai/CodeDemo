package thread;

/**
 * @Classname MyThread3
 * @Description TODO
 * @Date 2022-12-4 9:58
 * @Created by mubai
 */
public class MyThread3 extends Thread {
    private int count = 5;

    @Override
    public void run() {
        super.run();
        System.out.println("当前线程:" + currentThread().getName() + " 计算,count=" + (count--));
    }
}
