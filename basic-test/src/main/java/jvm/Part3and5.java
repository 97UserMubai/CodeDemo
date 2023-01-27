package jvm;

/**
 * @Classname Part3and5
 * @Description 第三章，进行MinorGC观察  -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * 输出日志
 * 按照上面的配置，堆内存的大小为10M，老年代是10M，新生代Eden的比例是8:1:1
 * 在进行Survivor分配的时候，只有1M，所以每次分配都应该会先分配Eden区域，当Eden不足时，发现Survivor区域1M的大小不足时就触发YoungGC
 * todo 和期望的不一样的是，在这个位置没有成功达到期望的输出，直接进行了FullGC，原始的
 * @Date 2023-1-23 10:39
 * @Created by mubai
 */
public class Part3and5 {
    private static final int _1MB = 1024 * 1024;

    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        //todo 这个位置，如果先分配一个allocation1 直接就输出Allocation Failure，但是堆内存的信息是：
        /*
        * Heap
         PSYoungGen      total 9216K, used 3310K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
          eden space 8192K, 28% used [0x00000000ff600000,0x00000000ff83d8a0,0x00000000ffe00000)
          from space 1024K, 99% used [0x00000000ffe00000,0x00000000ffefdfd8,0x00000000fff00000)
          to   space 1024K, 0% used [0x00000000fff00000,0x00000000fff00000,0x0000000100000000)
         ParOldGen       total 10240K, used 942K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
          object space 10240K, 9% used [0x00000000fec00000,0x00000000feceba18,0x00000000ff600000)
         Metaspace       used 3158K, capacity 4556K, committed 4864K, reserved 1056768K
          class space    used 332K, capacity 392K, committed 512K, reserved 1048576K
        * */
        allocation1 = new byte[2 * _1MB]; //[GC (Allocation Failure) [PSYoungGen: 7920K->999K(9216K)] 7920K->1954K(19456K), 0.0021542 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[2 * _1MB]; //发生了一次FullGC
        //[GC (Allocation Failure) [PSYoungGen: 7468K->1015K(9216K)] 8436K->8200K(19456K), 0.0047966 secs] [Times: user=0.14 sys=0.02, real=0.00 secs]
        //[Full GC (Ergonomics) [PSYoungGen: 1015K->0K(9216K)] [ParOldGen: 7184K->7710K(10240K)] 8200K->7710K(19456K), [Metaspace: 3156K->3156K(1056768K)], 0.0105285 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
        //Heap
        // PSYoungGen      total 9216K, used 2212K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
        //  eden space 8192K, 27% used [0x00000000ff600000,0x00000000ff8290f0,0x00000000ffe00000)
        //  from space 1024K, 0% used [0x00000000fff00000,0x00000000fff00000,0x0000000100000000)
        //  to   space 1024K, 0% used [0x00000000ffe00000,0x00000000ffe00000,0x00000000fff00000)
        // ParOldGen       total 10240K, used 7710K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
        //  object space 10240K, 75% used [0x00000000fec00000,0x00000000ff387ba8,0x00000000ff600000)
        // Metaspace       used 3165K, capacity 4556K, committed 4864K, reserved 1056768K
        //  class space    used 332K, capacity 392K, committed 512K, reserved 1048576K
    }

    public static void main(String[] args) {
        testAllocation();
    }
}
