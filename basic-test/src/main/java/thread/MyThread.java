package thread;

/**
 * @Classname MyThread
 * @Description TODO
 * @Date 2022-12-4 9:35
 * @Created by mubai
 */
public class MyThread extends Thread {

    private int count = 5;

    public MyThread(String name) {
        super();
        this.setName(name);
    }

    @Override
    public void run() {
        super.run();
        while (count > 0) {
            count--;
            System.out.println("当前线程:" + currentThread().getName() + " 计算,count=" + count);
        }
    }

}
