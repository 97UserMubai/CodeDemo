package javaBasic.abstractBasic;

/**
 * @name: MainAb
 * @author: mubai.
 * @date: 2021/11/4
 * @version: 1.0
 * @description:
 */
public class MainAb {
    public static void main(String[] args) {
        OneAb oneAb = new ChildAb();
        oneAb.printOne();
        ExtendOne extendOne = new ExtendChild();
        extendOne.printOne();
    }
}
