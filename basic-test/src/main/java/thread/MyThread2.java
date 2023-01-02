package thread;

/**
 * @Classname MyThread2
 * @Description TODO
 * @Date 2022-12-4 9:41
 * @Created by mubai
 */
public class MyThread2 extends Thread {
    private int count = 5;

    @Override
    public synchronized void run() {
        super.run();
        count--;
        System.out.println("当前线程:" + currentThread().getName() + " 计算,count=" + count);
    }
}
