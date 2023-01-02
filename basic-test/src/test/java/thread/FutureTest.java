package thread;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Classname FutureTest
 * @Description TODO
 * @Date 2022-9-4 13:06
 * @Created by mubai
 */
public class FutureTest {

    @Test
    public void testThreadPool() throws IOException, ExecutionException, InterruptedException {
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(16);
        ThreadFactory threadFactory = new NameThreadFactory();
        RejectedExecutionHandler handler = new MyIgnorePolicy();
        /*
         * 两个核心线程，最大线程数为4，阻塞队列的容量为2，那么最大的工作容量为6,四个线程有自己的task+两个阻塞队列
         * */
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS, workQueue,
                threadFactory, handler);
        //这里进行主线程的预热
        executor.prestartAllCoreThreads();

        for (int i = 1; i <= 10; i++) {
            MyTask task = new MyTask(String.valueOf(i));
            executor.execute(task);
        }

        System.out.println("----task test end----");

        //主线程休眠5秒钟，避免阻塞下面的future测试

        List<Future<Integer>> futures = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            futures.add(executor.submit(new MyCallable(i)));
        }

        System.out.println("-------------future submit end-------------");
        for (Future<Integer> future : futures) {
            System.out.println("Future result is :" + future.get() + "; And task done is :" + future.isDone());
        }

        executor.shutdown();
    }


    static class NameThreadFactory implements ThreadFactory {

        private final AtomicInteger mThreadNum = new AtomicInteger();

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r, "my-thread-" + mThreadNum.getAndIncrement());
            System.out.println(t.getName() + " has been created");
            return t;
        }

    }

    static class MyIgnorePolicy implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println(r.toString() + " rejected");
        }
    }

    static class MyCallable implements Callable<Integer> {

        private Integer number;

        public MyCallable(Integer number) {
            this.number = number;
        }

        @Override
        public Integer call() throws Exception {
            int result = 1;
            if (number == 0 || number == 1) {
                return 1;
            } else {
                for (int i = 1; i <= number; i++) {
                    result *= i;
                }
            }
            return result;
        }
    }

    static class MyTask implements Runnable {

        private String name;

        public MyTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                System.out.println(this.toString() + " is running!");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("MyTask{");
            sb.append("name='").append(name).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

}

