package designPattern.proxyPattern;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @name: RoomAgency
 * @author: mubai.
 * @date: 2022/1/4
 * @version: 1.0
 * @description:
 */
@AllArgsConstructor
@NoArgsConstructor
public class RoomAgency implements IRoom {
    private IRoom xiaoming;

    @Override
    public void seekRoom() {
        xiaoming.seekRoom();
    }

    @Override
    public void watchRoom() {
        xiaoming.watchRoom();
    }

    @Override
    public void rentRoom() {
        xiaoming.rentRoom();
    }

    @Override
    public void finish() {
        xiaoming.finish();
    }
}
