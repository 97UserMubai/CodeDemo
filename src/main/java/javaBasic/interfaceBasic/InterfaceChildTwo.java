package javaBasic.interfaceBasic;

/**
 * @name: InterfaceChildTwo
 * @author: mubai.
 * @date: 2021/11/9
 * @version: 1.0
 * @description:
 */
public class InterfaceChildTwo implements InterfaceD {
    @Override
    public void printC() {
        System.out.println("from interface c");
    }

    @Override
    public void printT() {
        System.out.println("from interface T");
    }
}
