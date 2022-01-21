package designPattern.templateMethodPattern;

/**
 * @Classname Client
 * @Description k客户端
 * @Date 2021/5/24 17:32
 * @Created by mubai
 */
public class Client {
    public static void main(String[] args) {
        FishCook fishCook = new FishCook();
        fishCook.cookProcess();
        VegCook vegCook = new VegCook();
        vegCook.cookProcess();
    }
}
