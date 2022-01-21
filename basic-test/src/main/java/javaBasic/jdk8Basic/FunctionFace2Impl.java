package javaBasic.jdk8Basic;

/**
 * @name: FunctionFace2Impl
 * @author: mubai.
 * @date: 2022/1/19
 * @version: 1.0
 * @description:
 */
public class FunctionFace2Impl implements FunctionFace {
    @Override
    public void method() {
        System.out.println("这个实现类将不会重写父接口的默认方法");
    }
}
