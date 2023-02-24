package basic;

import com.alibaba.fastjson.JSON;
import es.entity.Student;
import exception.MyException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @name: BasicTest
 * @author: mubai.
 * @date: 2022/5/23
 * @version: 1.0
 * @description:
 */
public class BasicTest {

    private final static String pubKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA17Sc/mUOXwR9NOUzczPvVbvbmHtFyy3n/jsBzfi8nNsG1zWxtCFWSXcb5pWiq8frVe+DHTdBTTgpFkTbaFSR/sRJ1IIGUjFSD0u+eeOs1nHPN5lgsw+Zgu7uIv424vvRxjrk0XvhRMK9+YUdFhlIU2C2oeTCFw9zHP6joLIw7zc19sKnXZ83bA1ry5daXAgOIinsDKVJDaZg2W2Mwq74L2z+OTKH7TSChj5pgFsll6yWgp/rjJoAAERjsHDi1Wh29m7hEhfm0L7iHoAiRK0Wy6EScDzfzLIERM79vg7eHw6Kum+zLQtEh1qVBswVpfJHiox98N4ucVuZ9XE40tQMjQIDAQAB";
    private final static String priKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDXtJz+ZQ5fBH005TNzM+9Vu9uYe0XLLef+OwHN+Lyc2wbXNbG0IVZJdxvmlaKrx+tV74MdN0FNOCkWRNtoVJH+xEnUggZSMVIPS75546zWcc83mWCzD5mC7u4i/jbi+9HGOuTRe+FEwr35hR0WGUhTYLah5MIXD3Mc/qOgsjDvNzX2wqddnzdsDWvLl1pcCA4iKewMpUkNpmDZbYzCrvgvbP45MoftNIKGPmmAWyWXrJaCn+uMmgAARGOwcOLVaHb2buESF+bQvuIegCJErRbLoRJwPN/MsgREzv2+Dt4fDoq6b7MtC0SHWpUGzBWl8keKjH3w3i5xW5n1cTjS1AyNAgMBAAECggEATijo1hlCCtXylG8UpILGD1fBq0/Hq2aX8HvrHHorxd5rbSHMoUuPG5GoL3Y6+mm3cW0XIkf6RoO6B5KtufEi8aCoa/MtXSz34gj9HOeNoiqc/jV6X4eghVwUN+PLeZXrnhuK/AkaSDMUaUx9jJtepK+fnavpVDfJ61Ctc7X9mz/IfNwihQAukk4ZZS0ULTYbgvrteq6cXVr76r2nLrkZMLi3EejG3pbVexZoaTuujDqo5wYUrf8wQDCI0eKsHrbJLn6BsUTKZXVJ5i+leKuCoTQhkx2ECjjO1nA7U2095L9CsSkvWxdsa6MyZnCfyoJQyR+InJ/mhaaIiUJhPHLAdQKBgQD78pf4OC/9il3FIE4ZxhVhATsYTVRvmN6LIqthaTPiKheGnlRXGH7n2eBl59fPyziPkTpxeI8ruv+RUrPzf/RNiwRJ+Ba4sCLEmgSHkqUIHLfOSf/t8CjHxzXpus986mgTtfMmuUh1n5kMANEmD1uXRV6jrblIMK7El+GlYDr7OwKBgQDbLMp/hzROOAHzf1Rn9owYBnZn+FI1DowTng388nCIdKyFPD1yrE7YdMN71Rjs0iogblchqEikC9Kofay+KSBKyBkZkTrIceAMiI1JpUoSnwNID1m5/W2uYcXyx9pM0fn25liZ/UFilYcmEGTLyQ+WJ9ToOJhw8jcnUdJuG0RK1wKBgBTIWBzTlbHWXhHKrmaV3mGYFmXUyyhBdeoIPBbW9L6tNi+Wk+JzVNSPNmFxlG3Bl7LQCgAeL8EttbMpHUryvRZAZ2QqoMUvUk7hXYpJYG+g3tCXbhMUgmioWBwlmsP1Ggy2L458Liv1tEw3LQl0rtt1j270/5mi2mfBF43quDLNAoGBAJNwmzyVAJvJ044xTt+tHGshFdA1XV/xzEt6HODXWtqA2nm6n3+f6F52lfac0OqnKs2sTJMIuO0aQvkzqdw2oFGOMExhxVCIQndL+Pfc6GqEa9my8eJLWNhhT59V0EWzT1tHc70LgEvIWSVDC/uG4yRY4UHiqLH6Tx31TgDh+Nv7AoGBAMPKDRV2ACjvi7OEuol6HZVvEMl/AwaDbIlYT5VEB8sGW4sJniFixUUYCWHBFukaqN8GV78ynqxj+ZoN/Yj3hpuYTvmf0Cwn/RCvHDuvPGs1ilZK2BlsNVTeDqgxT74yPek73HxJe4/hxoSCWzeyBoYrCm0sVxAMU9lmw4BbfQ1o";


    @Test
    public void testPad() {
        System.out.println("debug");
    }

    public static Map<String, Object> getJwtInfoFromToken(String token, String pubKey) throws Exception {

        byte[] decode = Base64.getDecoder().decode(pubKey);

        Map<String, Object> result = new HashMap<>(8);
        X509EncodedKeySpec spec = new X509EncodedKeySpec(decode);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PublicKey publicKey = kf.generatePublic(spec);

        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(publicKey).parseClaimsJws(token);
        Claims body = claimsJws.getBody();
        result.put("sourceSystem", body.get("sourceSystem"));
        result.put("sourceSystemUrl", body.get("sourceSystemUrl"));
        result.put("instanceInfo", body.get("instanceInfo"));
        result.put("userInfo", body.get("userInfo"));
        result.put("sessionId", body.get("sessionId"));
        result.put("masterInfo", body.get("masterInfo"));
        result.put("slaveInfo", body.get("slaveInfo"));
        result.put("isMaster", body.get("isMaster"));

        return result;
    }

    @Test
    public void testJwt() throws Exception {

        String userAddToken = "eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJDSEFOX0hVIiwic291cmNlU3lzdGVtVXJsIjoiaHR0cHM6Ly93b3p6eS5jb20uY24iLCJzb3VyY2VTeXN0ZW0iOiJDSEFOX0hVIiwiaW5zdGFuY2VJbmZvIjp7InNlcnZpY2VJZCI6InRlc3RfMTIzNCJ9LCJtYXN0ZXJJbmZvIjp7InBob25lIjoiMTg2MTIzNDEyMzQiLCJtYXN0ZXJPcGVuSWQiOiJtYXN0ZXIgb3BlbklkIiwicGhvbmVBcmVhIjoiKzg2IiwidXNlck5hbWUiOiJ1c2VyTmFtZV90ZXN0In0sImlzTWFzdGVyIjp0cnVlfQ.aFZQ8CetW5ChJeRR1SvXpPA2KEjBQMq3olR2wGdHw-zU_G2CO3FiCStox06Qkp39fo04Z3rCA2rgI7TVb_5niRLZbtnroS1WA_bEMav2Bx691w1LLVkfLH-LVyojlLsb-iEtZa1KTCAaM-PDNKGh2dcBCLamZnd5vXvNYSkua0q3EXxOFsEBAfraMh7UNlOtZosySRfeaK7T_dH9Mr_Srl_TiFhpi_s1XRcFCUPRIkPxLzKU2xPMI2rIwaF6CF7SkvcMLnwoJUx-yWZsqUOb3PcNjApCkNdyjakO_Igxn0JlEQBGgj4VJvh0T5cJHq3P6DGVl7glLnwdk1mMKw2mKg";
        Map<String, Object> userAdd = getJwtInfoFromToken(userAddToken, pubKey);
        LinkedHashMap<String, String> instanceMap = (LinkedHashMap<String, String>) userAdd.get("instanceInfo");
        String serviceId = instanceMap.get("serviceId");
        LinkedHashMap<String, String> userInfoMap = (LinkedHashMap<String, String>) userAdd.get("masterInfo");
        String phone = userInfoMap.get("phone");
        String openId = userInfoMap.get("masterOpenId");
        String userName = userInfoMap.get("userName");
        System.out.println(JSON.toJSONString(userAdd));

        System.out.println("=========================================");

        /**
         * 瑙ｆ瀽鍗曠偣鐧诲綍鎺ュ彛token鍙傛暟
         */
        String loginToken = "eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJDSEFOX0hVIiwic291cmNlU3lzdGVtVXJsIjoiaHR0cHM6Ly93b3p6eS5jb20uY24iLCJzb3VyY2VTeXN0ZW0iOiJDSEFOX0hVIiwiaW5zdGFuY2VJbmZvIjp7InNlcnZpY2VJZCI6InRlc3RfMTIzNCJ9LCJtYXN0ZXJJbmZvIjp7InBob25lIjoiMTg2MTIzNDEyMzQiLCJtYXN0ZXJPcGVuSWQiOiJtYXN0ZXIgb3BlbklkIiwicGhvbmVBcmVhIjoiKzg2IiwidXNlck5hbWUiOiJ1c2VyTmFtZV90ZXN0In0sInVzZXJJbmZvIjp7InBob25lIjoiMTg2MTIzNDEyMzQiLCJvcGVuSWQiOiJvcGVuSWQiLCJwaG9uZUFyZWEiOiIrODYiLCJ1c2VyTmFtZSI6InVzZXJOYW1lX3Rlc3QiLCJtYXN0ZXIiOnRydWV9fQ.QRJInI7Zyw-GNv7Z5QrSjxP13YhRXcz1WdQwvRwpYMydXH_rlom6Pu1_UDTQjDIGkTdq5xYFmN6oQfhVT5H77sZKtenLiPydOf-3vWhZ5BMAfhYLCEWJeVP-NEsy0oj72LYQPz_BifhQUTgcBLU8rDtQ6W1CHHMNpdmKcW83_Q4teGR4xtstCVkfH8LscZP1TXwtatEEbMKiHXYI14n8pPBg-qkmLXrt0rgy7epWlCYylhvi70_-kGZsbJqlxvRRLgL3FAcWvt2gjdSwRo8tK0tYZqCz8yTWl_833PfLAfvATWCLDrLOhfg09e8wHyh0WbdpNBLd8g6PuBKkNq1FGA";
        Map<String, Object> login = getJwtInfoFromToken(loginToken, pubKey);
        System.out.println(JSON.toJSONString(login));
    }


    @Test
    public void testHashMap() {
        System.out.println(LocalTime.MAX);
    }

    @Test
    public void testException() {
        try {
            getMyException();
        } catch (MyException e) {
            System.out.println(e.getDiyMsg());
        }
    }


    public void getMyException() {
        throw new MyException("异常主体", "自定义内容", 1);
    }

    @Test
    public void test() {
        BigDecimal price = new BigDecimal("3.1111");
        BigDecimal energy = new BigDecimal("0.5");
        System.out.println(price.multiply(energy).setScale(2, BigDecimal.ROUND_HALF_UP));
    }

    @Test
    public void testBigDecimal() {
        BigDecimal result = new BigDecimal("74.8576").setScale(1, RoundingMode.HALF_DOWN)
                .subtract(new BigDecimal("74.8"));
        System.out.println(new BigDecimal("74.8576").setScale(1, RoundingMode.HALF_DOWN));
        System.out.println(new BigDecimal("74.8576").setScale(1, BigDecimal.ROUND_DOWN));
        System.out.println(result);
    }

    /**
     * 进行参数传递形参和实参的测试
     * 首先，实参和形参的概念
     * 实参：用于传递给方法的参数，已经是定义好的，JVM分配了内存的值(对象)
     * 形参：方法参数上的定于，用于接受实参，实参给的是什么就是什么
     * 参数传递的方式有两种：
     * 1.值传递：是对方法接受的实参的拷贝，是一个副本，并不会改变实参自己的值，
     * 2.引用传递：传递的是引用对象的地址，引用对象的内容可以修改
     * 虽然说Java的参数中只有值传递，但是如果Java本身也是有引用类型的，如果在传递时传递引用对象就不会修改对象内容了吗，今天测试目标就是测试
     * 值传递和引用传递在Java中是否符合直觉
     * <p>
     * 划重点：
     * Java中值传递的介绍： 如果是基础类型(包装类)传递的是字面量值的拷贝，会创建副本，如果是引用类型，则传递的是实参对象的堆内存地址，也会创建副本
     */
    @Test
    public void testParamDeliver() {
        //定义两个基础数据类型的实参
        int num1 = 100;
        int num2 = 200;
        swap(num1, num2);
        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
        //进行引用类型的测试
        Student student = new Student();
        student.setId(1L);
        student.setAge(12);
        System.out.println(JSON.toJSONString(student));
        swap(num1, num2, student);
        System.out.println(JSON.toJSONString(student));
        //ouput:
        //a =200
        //b =100
        //num1 = 100
        //num2 = 200   ----------这个位置可以看出值类型传递的结果里面形参的结果是不会改变的
        //{"age":12,"id":1}
        //a =200
        //b =100
        //{"age":12,"id":1,"key":"222","name":"xxxx"}
        //{"age":12,"id":1,"key":"222","name":"xxxx"} -- 这个位置的输出可以看出引用类型的传递，内容确实会变化，并且这个位置要注意
        //引用类型的对象修改之后，其hash值如果没有特别重写equals和hashCode方法的话，值也是会变化的
        List<Student> students = new ArrayList<>();
        students.add(student);
        System.out.println(JSON.toJSONString(students));
        swap(num1, num2, students);
        System.out.println(JSON.toJSONString(students));
        //output:
        //[{"age":12,"id":1,"key":"222","name":"xxxx"}]
        //a =200
        //b =100
        //[{"age":12,"id":1,"key":"222","name":"xxxx"},{"age":13,"id":2}]  -- 这个位置的输出可以看出集合对象内部也是会被修改的
        Long num3 = 3L;
        Long num4 = 4L;
        swap(num3, num4);
        System.out.println("num3 = " + num3);
        System.out.println("num4 = " + num4);
        //output:
        //a =4
        //b =3
        //num3 = 3
        //num4 = 4 -- 这个位置的输出可以看出基础类型的包装类型

        //-- 看到上述的这些输出之后，再回头思考值传递和引用传递的介绍可以发现上面的案例完全符合引用传递的情况
        //但是：为什么一直都说Java是没有引用传递的？引用传递的弊端是什么，很多代码规范扫描器也会标识这种操作会引发bug？
        //详细看看Java中值传递的介绍： 如果是基础类型(包装类)传递的是字面量值的拷贝，会创建副本，
        // 如果是引用类型，则传递的是实参对象的堆内存地址，也会创建副本
        // 所以思考一下：引用类型中携带基础类型的时候，修改的时候实参的工作是怎么表现的？
        // 这里设计两个测试案例： 1.基础类型数组的修改 ， 2.引用对象中包含基础类型的修改
        System.out.println("----------下面是继续测试引用类型值传递的案例输出----------");
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(arr[0]);
        change(arr);
        System.out.println(arr[0]);
        Student student1 = new Student();
        student1.setAge(18);
        Student student2 = new Student();
        student2.setAge(98);
        swap(student1, student2);
        System.out.println("student1 age = " + student1.getAge());
        System.out.println("student2 age = " + student2.getAge());
        //output:
        //----------下面是继续测试引用类型值传递的案例输出----------
        //1
        //0
        //student1 age = 98
        //student2 age = 18
        //student1 age = 18
        //student2 age = 98
        //从上面的输出可以看到基础数据类型的数组在传递的时候依然会造成原来实参数组的变化，这说明拷贝的是指引用对象的地址(值传递的内容)
        //再看看第二个案例的输出，可以发现尽管传递的引用对象中，swap方法，互换了对象，但是实参依然没有被修改
        //这说明引用对象的副本只要不修改具体的内容，副本地址就算改了也不会影响到原来的实参内容
        //good ， 写了这么多还是没什么卵用，引用传递的问题在Java中依然是存在的，编写的时候还是会修改引用对象的内容，尽管传递的是引用对象的地址
        //但是依然不可避免修改内容时候会引发的bug问题，还是需要开发人员主观地判断引用对象在传参是修改会带来的上下文影响
    }

    public void swap(Student student1, Student student2) {
        Student temp = student1;
        student1 = student2;
        student2 = temp;
        System.out.println("student1 age = " + student1.getAge());
        System.out.println("student2 age = " + student2.getAge());
    }

    public void change(int[] array) {
        array[0] = 0;
    }

    public void swap(Long a, Long b) {
        Long temp = a;
        a = b;
        b = temp;
        System.out.println("a =" + a);
        System.out.println("b =" + b);
    }

    public void swap(int a, int b, List<Student> students) {
        swap(a, b);
        Student student = new Student();
        student.setId(2L);
        student.setAge(13);
        students.add(student);
    }

    /**
     * 进行值交换之后输出
     *
     * @param a 形参a
     * @param b 形参b
     */
    public void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println("a =" + a);
        System.out.println("b =" + b);
    }

    public void swap(int a, int b, Student student) {
        swap(a, b);
        student.setName("xxxx");
        student.setKey("222");
        System.out.println(JSON.toJSONString(student));
        AtomicInteger atomicInteger = new AtomicInteger(1);
        atomicInteger.getAndSet(1);
    }

    @Test
    public void testRandom() {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 1; i <= 10000; i++) {
            list.add(random.nextInt(22));
        }
        Map<Integer,Long> randomMap = list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(randomMap);
    }


}
