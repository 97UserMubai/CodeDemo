package javaBasic.abstractBasic;

/**
 * @Classname AbstractMain
 * @Description
 * @Date 2021/10/3 11:01
 * @Created by mubai
 */
public class AbstractMain {

    public static void main(String[] args) {
        printTest(new Child());
    }


    static void printTest(AbstractTest test) {
        System.out.println("main deploy");
        test.add();
    }
}
