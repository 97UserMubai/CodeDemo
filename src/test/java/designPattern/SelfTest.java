package designPattern;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void testDoublie() {
        double s = Double.parseDouble("-114.145537");
        double d = (double) Math.round(Math.abs(s) * 10000) / 10000;
        System.out.println(d);
    }

    @Test
    public void testRest() {
        int a = -5;
        System.out.println(a >>= 4);
    }

    @Test
    public void testList() {
        List<String> factoryIds = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            factoryIds.add(String.valueOf(i));
        }
        factoryIds.add(null);
        System.out.println("debug");
        factoryIds.forEach(id-> System.out.println(id.toString()));
    }


    @Test
    public void testCompare(){
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime hour = localDateTime.minusHours(1);
        LocalDateTime before = hour.plusMinutes(2);
        System.out.println(hour.compareTo(before));
        System.out.println(hour.compareTo(localDateTime.minusHours(1)));
        System.out.println(before.compareTo(hour));
    }
}
