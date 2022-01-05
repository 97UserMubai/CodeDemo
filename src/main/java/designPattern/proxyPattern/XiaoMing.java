package designPattern.proxyPattern;

/**
 * @name: XiaoMing
 * @author: mubai.
 * @date: 2022/1/4
 * @version: 1.0
 * @description:
 */
public class XiaoMing implements IRoom {
    @Override
    public void seekRoom() {
        System.out.println("找房");
    }

    @Override
    public void watchRoom() {
        System.out.println("看房");
    }

    @Override
    public void rentRoom() {
        System.out.println("租房");
    }

    @Override
    public void finish() {
        System.out.println("完成租房");
    }
}
