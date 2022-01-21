package designPattern.proxyPattern;

/**
 * @name: IRoom
 * @author: mubai.
 * @date: 2022/1/4
 * @version: 1.0
 * @description: 租房公共接口
 */
public interface IRoom {
    void seekRoom(); //找房

    void watchRoom(); //看房

    void rentRoom(); //租房

    void finish(); //完成
}
