package jvm;

/**
 * @Classname Part2and4
 * @Description 测试StockOverFlowError JVM配置 ： -Xss128k
 * @Date 2023-1-20 21:20
 * @Created by mubai
 */
public class Part2and4 {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        Part2and4 part2and4 = new Part2and4();
        try {
            part2and4.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + part2and4.stackLength);
            throw e;
        }
    }

}
