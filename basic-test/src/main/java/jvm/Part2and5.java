package jvm;

/**
 * @Classname Part2and5
 * @Description 测试多线程环境下，内存异常异常，JVM配置：  -Xms20M -Xmx20M -Xss2M
 * @Date 2023-1-20 21:31
 * @Created by mubai
 */
public class Part2and5 {
    private void dontStop() {
        while (true) {

        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(() -> dontStop());
            thread.start();
        }
    }

    public static void main(String[] args) {
        Part2and5 part2and5 = new Part2and5();
        part2and5.stackLeakByThread();
    }
}
