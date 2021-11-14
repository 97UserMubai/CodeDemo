package javaBasic.interfaceBasic;

/**
 * @name: InterfaceMain
 * @author: mubai.
 * @date: 2021/11/4
 * @version: 1.0
 * @description:
 */
public class InterfaceMain {
    public static void main(String[] args) {
        InterfaceT interfaceT1 = new InterfaceChildTwo();
        interfaceT1.printT();
        InterfaceD interfaceD = new InterfaceChildTwo();
        interfaceD.printC();
        interfaceD.printT();
        InterfaceC interfaceC = new InterfaceChildTwo();
        interfaceC.printC();
        System.out.println(InterfaceA.randomInt);
        System.out.println(InterfaceA.randomLong);
        System.out.println(InterfaceA.randomFloat);
        System.out.println(InterfaceA.randomDouble);
        System.out.println(InterfaceA.randomInt);
    }
}
