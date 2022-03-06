package javaBasic.jdk8Basic.function.easyImpl;

public class LambdaExpressions {

    /**
     * 通过lambda表达式结合接口函数来实现比匿名内部类更简洁的代码
     */
    static Body body = h -> h + "from Body";
    static Description desc = () -> "from Description";
    static Multi multi = (h, d) -> h + d;
    static Description moreLine = () -> {
        System.out.println("description brief()");
        return "from description brief";
    };

    public static void main(String[] args) {
        System.out.println(body.detailed("Hi,"));
        System.out.println(desc.brief());
        System.out.println(multi.twoArg("Hi,", 2.00));
        System.out.println(moreLine.brief());
    }

}
