package designPattern.templateMethodPattern;

/**
 * @Classname FishCook
 * @Description
 * @Date 2021/5/24 17:30
 * @Created by mubai
 */
public class FishCook extends AbstractCook{
    @Override
    void pourFood() {
        System.out.println("你加入了一条巴掌大的鱼");
    }

    @Override
    void pourSauce() {
        System.out.println("你倒入了生抽，太tm咸了，这本来就是一条咸鱼啊");
    }
}
