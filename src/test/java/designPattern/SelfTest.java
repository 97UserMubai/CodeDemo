package designPattern;

import org.junit.Test;

/**
 * @author by mubai
 * @Classname Test
 * @Description
 * @Date 2021/7/7 14:37
 */
public class SelfTest {

    @Test
    public void parseSpecialChar() {
        String str = "2AP/_空调";
        str = str.replace("//", "/");
        str = str.replace("/%", "%");
        str = str.replace("/_", "_");
        System.out.println(str);
    }
}
