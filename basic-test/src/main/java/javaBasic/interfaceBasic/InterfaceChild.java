package javaBasic.interfaceBasic;

/**
 * @name: InterfaceChild
 * @author: mubai.
 * @date: 2021/11/4
 * @version: 1.0
 * @description:
 */
public class InterfaceChild implements InterfaceT {
    @Override
    public void printT() {
        System.out.println(InterfaceT.CONSTANT_STR);
    }
}
