package designPattern.proxyPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @name: Client
 * @author: mubai.
 * @date: 2022/1/4
 * @version: 1.0
 * @description:
 */
public class Client {
    public static void main(String[] args) {
        XiaoMing xiaoMing = new XiaoMing();

        RoomAgency roomAgency = new RoomAgency(xiaoMing);

        List<String> arr = new ArrayList<>();

        roomAgency.seekRoom();
        roomAgency.watchRoom();
        roomAgency.rentRoom();
        roomAgency.finish();
    }
}
