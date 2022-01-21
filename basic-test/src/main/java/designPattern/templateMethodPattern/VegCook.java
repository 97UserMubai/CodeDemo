package designPattern.templateMethodPattern;

/**
 * @Classname VegCook
 * @Description
 * @Date 2021/5/24 17:31
 * @Created by mubai
 */
public class VegCook extends AbstractCook{

    @Override
    void pourFood() {
        System.out.println("你加入了一盆青菜");
    }

    @Override
    void pourSauce() {
        System.out.println("你倒入了少量食盐，味道完美，不愧是王狗子的徒弟");
    }
}
