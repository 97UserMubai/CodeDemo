package designPattern.factoryPattern;

import java.util.Scanner;

/**
 * @author wangbaitao
 * @version 1.0.0
 * <h>抽象工厂模式</h>
 * <pre>
 *     抽象工厂模式基于工厂方法模式，区别在于抽象工厂可以支持一个产品族群的对象创建
 *     由于需求复杂后会导致每增加一个产品之后，都需要将所有实现了该抽象接口的具体工厂都同时实现该接口
 *     所以在这里会提供另外一种实现方式：
 *     反射机制+简单工厂模式
 * </pre>
 * @Date 2021/4/28
 **/
public class AbstractFactoryPattern {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        AbstractFactory dellFactory = new DellFactory();
        dellFactory.createMouse().click();
        dellFactory.createKeyBoard().type();
        AbstractFactory lenovoFactory = new LenovoFactory();
        lenovoFactory.createMouse().click();
        lenovoFactory.createKeyBoard().type();
        System.out.println("下面将采用反射机制+简单工厂模式来实现,请键入类型(Dell/Lenovo)：");
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        SimpleFactoryWithRevoke.createMouse(type).click();
        SimpleFactoryWithRevoke.createKeyBoard(type).type();
    }
}

/**
 * 抽象产品-鼠标
 */
interface Mouse {
    void click();
}

/**
 * 具体产品-戴尔鼠标
 */
class DellMouse implements Mouse {
    public void click() {
        System.out.println("你使用了Dell鼠标进行click");
    }
}

/**
 * 具体产品联想鼠标
 */
class LenovoMouse implements Mouse {
    public void click() {
        System.out.println("你使用了联项鼠标进行click");
    }
}

/**
 * 抽象产品-键盘
 */
interface KeyBoard {
    void type();
}

/**
 * 具体产品-戴尔键盘
 */
class DellKeyBoard implements KeyBoard {
    public void type() {
        System.out.println("你使用了Dell键盘进行输入");
    }
}

/**
 * 具体产品-联想键盘
 */
class LenovoKeyBoard implements KeyBoard {
    public void type() {
        System.out.println("你使用了联想键盘进行输入");
    }
}

/**
 * 抽象工厂
 * 当产品族的需求增加时，所有子接口都必须实现新增的方法
 */
interface AbstractFactory {
    Mouse createMouse();

    KeyBoard createKeyBoard();
}

/**
 * 具体工厂-生产戴尔系列的产品
 */
class DellFactory implements AbstractFactory {

    public Mouse createMouse() {
        return new DellMouse();
    }

    public KeyBoard createKeyBoard() {
        return new DellKeyBoard();
    }
}

/**
 * 具体工厂-生产联想系列的产品
 */
class LenovoFactory implements AbstractFactory {

    public Mouse createMouse() {
        return new LenovoMouse();
    }

    public KeyBoard createKeyBoard() {
        return new LenovoKeyBoard();
    }
}

/**
 * 使用反射机制+简单工厂模式
 */
class SimpleFactoryWithRevoke {
    private static final String packageName = "designPattern.factoryMethodPattern.";

    public static Mouse createMouse(String name) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return (Mouse) Class.forName(packageName + name + "Mouse").newInstance();
    }

    public static KeyBoard createKeyBoard(String name) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return (KeyBoard) Class.forName(packageName + name + "KeyBoard").newInstance();
    }
}
