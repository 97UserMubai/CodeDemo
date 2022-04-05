package designPattern.adapterPattern;

/**
 * @Classname ClassAdapter
 * @Description 类适配器
 * @Date 2022-4-3 22:56
 * @Created by mubai
 */
public class ClassAdapter extends Adaptee implements Target {
    @Override
    public void request() {
        adjustRequest();
    }
}
