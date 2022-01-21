package designPattern;

import org.joda.time.DateTime;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        factoryIds.forEach(id -> System.out.println(id.toString()));
    }


    @Test
    public void testCompare() {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime hour = localDateTime.minusHours(1);
        LocalDateTime before = hour.plusMinutes(2);
        System.out.println(hour.compareTo(before));
        System.out.println(hour.compareTo(localDateTime.minusHours(1)));
        System.out.println(before.compareTo(hour));
    }

    @Test
    public void test() {
        String str = "第200层";
        String level = str.substring(str.indexOf("第") + 1, str.indexOf("层"));
        System.out.println(Integer.valueOf("200 ".trim()));
        System.out.println(level);
    }

    @Test
    public void test2() {
        String str = "第200层";
        String str4 = "第2层";
        String str2 = "第二层";
        String str3 = "二层";
        String regex = "^第[1-9]+[0-9]*层$";
        System.out.println(str.matches(regex));
        System.out.println(str2.matches(regex));
        System.out.println(str3.matches(regex));
        System.out.println(str4.matches(regex));
    }


    @Test
    public void test3() {
        String str = "123456789123456";
        String str2 = "12345678998657";
        System.out.println(str.substring(9));
        System.out.println(str2.substring(9));
    }

    @Test
    public void test4() {
        List<Integer> test = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            test.add(i);
        }
        List<Integer> result = test.subList(0, 5);
        System.out.println("debug");
    }

    @Test
    public void test5() {
        LocalDate localDate = LocalDate.parse("2021-10-25", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(localDate.plusDays(6));
        System.out.println("debug");
    }

    @Test
    public void test6() {
        System.out.println(100 == 100.0);
        System.out.println(100.0 == 100.0);
        System.out.println(100.00 == 100.0);
    }

    @Test
    public void test7() {
        List<Integer> v1 = new ArrayList<>();
        v1.add(1);
        v1.add(2);
        v1.add(3);
        v1.add(4);
        List<Integer> v2 = new ArrayList<>();
        v2.add(4);
        v2.add(5);
        v2.add(6);
        v2.add(7);
        List<Integer> mergeResult = Stream.of(v1, v2)
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("debug");
    }

    @Test
    public void test8() {
        LocalDate localDate = LocalDate.now();
        LocalDate localDate1 = localDate.minusMonths(2);
        LocalDateTime localDateTime = localDate.atStartOfDay().withDayOfMonth(1);
        LocalDateTime localDateTime1 = localDate1.atStartOfDay().withDayOfMonth(1);
        System.out.println("debug");
    }

    @Test
    public void test9(){
        System.out.println((String)null);
    }
}
