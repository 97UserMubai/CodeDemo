package designPattern.adapterPattern;

/**
 * @Classname ObjectAdapter
 * @Description 对象适配器
 * @Date 2022-4-3 23:00
 * @Created by mubai
 */
public class ObjectAdapter implements Target {

    private Adaptee adaptee;

    public ObjectAdapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    public void request() {
        adaptee.adjustRequest();
    }
}
