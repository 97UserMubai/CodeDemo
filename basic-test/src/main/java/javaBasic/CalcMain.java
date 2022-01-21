package javaBasic;

/**
 * @Classname CalcMain
 * @Description 逻辑运算符测试案例 By 《java编程思想》
 * @Date 2021/10/14 21:32
 * @Created by mubai
 */
public class CalcMain {

    /**
     * >> 运算原则： 左移则低位补零，右移如果为正数则高位补0.负数则高位补1
     * >>> 逻辑右移，无论正数，高位都是补0  需要注意的是没有<<<这种运算符
     * 二进制中，正数就是正常的二进制转换，负数需要进行补码+1的转换之后再进行左移和右移，然后再进行计算
     * -20 >> 2 = -5 运算如下：
     * 原码为1001 0100 除符号位进行取反得到 1110 1011 + 1得到补码 1110 1100 右移两位得到 1111 1011(高位补1)，减一取反得到1000 0101 结果为-5
     */
    public static void main(String[] args) {
        System.out.println("以下为>>>运算结果");
        int i = -1;
        /*int i = -1 ,int类型，4个字节，长度为32位，-1则表示为10000000 00000000 00000000 00000001
         * >>>右移10位之后，零扩展规则，高位插入0，包括符号位，所以移动之后的结果为00000000 01000000 0000000 00000000*/
        i >>>= 10;
        System.out.println("int结果:" + i);
        System.out.println(Math.pow(2, 22));
        long l = -1;
        l >>>= 10;
        System.out.println("long结果:" + l); //按位运算之后输出结果为18014398509481983
        System.out.println(Math.pow(2, 54));//按照上面Int类型的处理方式，这里Long类型为64为，则应该是2的(64-10)次方，输出结果为1.8014398509481984E16

        short s = -1;
        shortToByte(s);
        /**/
        s >>>= 10;
        System.out.println("short结果:" + s); //输出结果为-1
        byte b = -1;
        b >>>= 10;
        System.out.println("byte结果:" + b); //byte长度为1bit，所以输出结果为-1

        test();
    }

    public static void shortToByte(short s) {
        byte[] arr = new byte[2];
        arr[0] = (byte) (s >> 8);
        arr[1] = (byte) (s & 0xff);
        System.out.println("byte数据" + s + "的二进制为:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void test() {
        System.out.println("以下为>>运算结果");
        int i = -1;
        i >>= 10;
        System.out.println("int结果:" + i); //按位运算之后输出结果为-1
        long l = -1;
        l >>= 10;
        System.out.println("long结果:" + l); //按位运算之后输出结果为-1
        short s = -1;
        /**/
        s >>= 10;
        System.out.println("short结果:" + s); //输出结果为-1
        byte b = -1;
        b >>= 10;
        System.out.println("byte结果:" + b); //byte长度为1bit，所以输出结果为-1
    }

}
