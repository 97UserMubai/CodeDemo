package javaBasic.jdk8Basic;

/**
 * @name: FunctionFaceImpl
 * @author: mubai.
 * @date: 2022/1/19
 * @version: 1.0
 * @description:
 */
public class FunctionFaceImpl implements FunctionFace {
    @Override
    public void method() {
        System.out.println("正常实现函数式单一接口的输出");
    }

    @Override
    public String defaultMethod() {
        return "我是子类重写的默认方法";
    }
}
