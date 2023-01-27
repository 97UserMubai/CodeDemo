package jvm;

/**
 * @Classname Part3and6
 * @Description 第三章，进行大对象直接进入老年代的测试
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=2097152 -XX:+UseParNewGC
 * @Date 2023-1-23 11:24
 * @Created by mubai
 */
public class Part3and6 {
    private static final int _1MB = 1024 * 1024;

    public static void testAllocation() {
        byte[] allocation1;

        allocation1 = new byte[4 * _1MB];//直接分配到老年代
        //Heap
        // PSYoungGen      total 9216K, used 8084K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
        //  eden space 8192K, 98% used [0x00000000ff600000,0x00000000ffde5370,0x00000000ffe00000)
        //  from space 1024K, 0% used [0x00000000fff00000,0x00000000fff00000,0x0000000100000000)
        //  to   space 1024K, 0% used [0x00000000ffe00000,0x00000000ffe00000,0x00000000fff00000)
        // ParOldGen       total 10240K, used 4096K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
        //  object space 10240K, 40% used [0x00000000fec00000,0x00000000ff000010,0x00000000ff600000)
        // Metaspace       used 3157K, capacity 4556K, committed 4864K, reserved 1056768K
        //  class space    used 332K, capacity 392K, committed 512K, reserved 1048576K

        //todo 很奇怪的日志PSYoungGen 表示使用的是Parallel Scavenge收集器，这个收集器是针对吞吐量的，回收机制和测试目标的ParNew收集器不一样，但是补充了-XX:+UseParNewGC
        //开关之后的日志是：
        //Heap
        // par new generation   total 9216K, used 8084K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
        //  eden space 8192K,  98% used [0x00000000fec00000, 0x00000000ff3e53b0, 0x00000000ff400000)
        //  from space 1024K,   0% used [0x00000000ff400000, 0x00000000ff400000, 0x00000000ff500000)
        //  to   space 1024K,   0% used [0x00000000ff500000, 0x00000000ff500000, 0x00000000ff600000)
        // tenured generation   total 10240K, used 4096K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
        //   the space 10240K,  40% used [0x00000000ff600000, 0x00000000ffa00010, 0x00000000ffa00200, 0x0000000100000000)
        // Metaspace       used 3157K, capacity 4556K, committed 4864K, reserved 1056768K
        //  class space    used 332K, capacity 392K, committed 512K, reserved 1048576K
        //Disconnected from the target VM, address: '127.0.0.1:52993', transport: 'socket'

        //todo 问题是为啥Eden永远是98%的使用情况
    }

    public static void main(String[] args) {
        testAllocation();
    }
}
