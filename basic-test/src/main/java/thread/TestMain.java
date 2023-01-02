package thread;

/**
 * @Classname TestMain
 * @Description TODO
 * @Date 2022-12-4 9:38
 * @Created by mubai
 */
public class TestMain {
    public static void main(String[] args) {
//        MyThread threadA = new MyThread("threadA");
//        MyThread threadB = new MyThread("threadB");
//        MyThread threadC = new MyThread("threadC");
//        //多线程输出效果是随机的，但是由于是私域的变量所以不会有变量共享的问题
//        threadA.start();
//        threadB.start();
//        threadC.start();

        System.out.println("-----------------------下面是共享变量-----------------------");
        //下面这个输出，将每个子线程传给一个Thread对象，会发现线程不安全的请开给你出现
//        MyThread2 myThread = new MyThread2();
//        Thread A = new Thread(myThread,"A");
//        Thread B = new Thread(myThread,"B");
//        Thread C = new Thread(myThread,"C");
//        Thread D = new Thread(myThread,"D");
//        Thread E = new Thread(myThread,"E");
//        A.start();
//        B.start();
//        C.start();
//        D.start();
//        E.start();


        MyThread3 myThread = new MyThread3();
        //下面
        Thread A = new Thread(myThread, "A");
        Thread B = new Thread(myThread, "B");
        Thread C = new Thread(myThread, "C");
        Thread D = new Thread(myThread, "D");
        Thread E = new Thread(myThread, "E");
        A.start();
        B.start();
        C.start();
        D.start();
        E.start();
    }
}
