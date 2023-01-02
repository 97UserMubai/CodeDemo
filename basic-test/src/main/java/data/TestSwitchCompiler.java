package data;

/**
 * @Classname TestSwitchCompiler
 * @Description TODO
 * @Date 2022-12-22 22:10
 * @Created by mubai
 */
public class TestSwitchCompiler {
    public static void main(String[] args) {
        String str = "world";
        switch (str) {
            case "hello":
                System.out.println("hello");
                break;
            case "world":
                System.out.println("world");
                break;
            default:
                break;
        }
    }
}
