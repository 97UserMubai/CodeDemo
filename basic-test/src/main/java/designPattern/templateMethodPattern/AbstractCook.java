package designPattern.templateMethodPattern;

/**
 * @Classname AbstractCook
 * @Description 模板方法抽象类-食谱
 * @Date 2021/5/24 17:23
 * @Created by mubai
 */
public abstract class AbstractCook {
    /*定义一个基本的食谱骨架，炒菜流程是固定的：
    * 1、加入食用油
    * 2、加热食用油
    * 3、加入食物
    * 4、翻炒
    * 5、加入佐料
    * 6、起锅*/
    final void cookProcess() {
        this.pourOil();
        this.heatOil();
        this.pourFood();
        this.fry();
        this.pourSauce();
    }

    protected void pourOil() {
        System.out.println("你倒入了200ml花生油");
    }

    protected void heatOil() {
        System.out.println("经过30秒的强力加热，你的油已经快爆炸了");
    }

    abstract void pourFood();

    protected void fry() {
        System.out.println("你反复翻炒");
    }

    abstract void pourSauce();

    protected void end(){
        System.out.println("你完成了本次食谱的制作");
    }
}
