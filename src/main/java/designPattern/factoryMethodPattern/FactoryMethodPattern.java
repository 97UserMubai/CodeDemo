package designPattern.factoryMethodPattern;

/**
 * @author wangbaitao
 * @version 1.0.0
 * <h>简单工厂模式</h>
 * <pre>
 *     ①定义一个interface接口，设计子类通用的功能方法
 *     ②定义子类实现该接口
 *     ③定义Factory类，根据入参判断返回哪个子类对象
 *     这是一个十分简单的工厂模式，实际项目中很少使用，但是思想和其他工厂模式是一致的
 * </pre>
 * <pre>
 *     工厂模式思想：
 *     ①用户代码不需要跟子类耦合，创建实例的过程交给Factory完成，用户代码和子类实现完全解耦
 *     ②用户代码只需要知道有哪些子类可以提供服务，同时知道子类有哪些方法可以被调用即可
 * </pre>
 * @Date 2021/4/28
 **/
public class FactoryMethodPattern {
    public static void main(String[] args) throws Exception {
        System.out.println("Simple Factory Pattern");
        //简单工厂创建工厂对象
        SimpleFactory simpleFactory = new SimpleFactory();
        //获取不同的产品
        simpleFactory.produce("apple").call();
        simpleFactory.produce("huawei").call();
        //工厂模式创建工厂对象
        System.out.println("Factory Method Pattern");
        FactoryMethod appleFactory = new AppleFactory();
        appleFactory.produce().call();
        FactoryMethod huaweiFactory = new HuaWeiFactory();
        huaweiFactory.produce().call();
    }
}

/**
 * 抽象产品
 */
interface Phone {
    void call();
}

/**
 * 具体产品-apple
 */
class Apple implements Phone {
    public void call() {
        System.out.println("苹果手机为您提供电话服务");
    }
}

/**
 * 具体产品-huawei
 */
class Huawei implements Phone {
    public void call() {
        System.out.println("华为手机为您提供电话服务");
    }
}

/**
 * 简单工厂
 * 根据用户需求来创建对应的工厂实例
 * 如果有新的产品增加的话，需要同步修改Factory代码，这种设计存在一定程度的耦合
 */
class SimpleFactory {
    Phone produce(String type) throws Exception {
        if ("apple".equals(type)) {
            return new Apple();
        } else if ("huawei".equals(type)) {
            return new Huawei();
        } else {
            throw new Exception("no such product");
        }
    }
}

/**
 * 工厂方法模式
 * <pre>
 *     主要角色：
 *     抽象工厂对象：提供统一的实例创建抽象方法
 *     具体工厂对象：继承抽象工厂，进行对应的对象实例创建
 *     抽象产品对象：提供统一的产品接口
 *     具体产品独享：提供具体的产品
 * </pre>
 */
interface FactoryMethod {
    Phone produce();
}

/*** 具体工厂-生成apple*/
class AppleFactory implements FactoryMethod {
    public Phone produce() {
        return new Apple();
    }
}

/*** 具体工厂-生成huawei*/
class HuaWeiFactory implements FactoryMethod {
    public Phone produce() {
        return new Huawei();
    }
}