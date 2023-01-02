package effectiveJava.part2;

/**
 * @Classname GirlFriend
 * @Description EffectiveJava 第一章节——遇到多个构造器参数时要考虑使用构建器
 * <pre>
 *     这是一个Builder模式的使用案例
 *     1.在 GirlFriend 对象中，创建一个静态内部类Builder
 *     2.Builder类中创建一些函数类用于对应内部类属性的赋值，提供build方法返回一个 GirlFriend 对象
 *     3.NutritionFacts的构造器中使用静态内部类Builder对象
 *     4.Builder中的赋值函数返回的Builder对象使用this关键字，这个属于Java对象的基础用法，this将返回当前层级的对象，这里是静态内部类就会指向静态内部类
 *     最后的调用链路为：new GirlFriend.Builder().build();
 *     观察上面的链路可以发现，new的对象那个是GirlFriend.Builder的构造器，并没有直接创建一个GirlFriend对象
 *     其本质跟Builder模式就是一个东西，但是Builder模式用于单个类模式，当存在多态模式继承的类层次模式的时候，如何使用Builder模式？
 *     {@link effectiveJava.part2.AbstractFriend}
 * </pre>
 * @Date 2022-10-29 17:19
 * @Created by mubai
 */
public class GirlFriend {

    //这里一个常见的Java使用问题，当使用final修饰关键字时，如果没有赋值，那么就必须构造函数中进行参数设置
    private final int high;
    private final int weight;
    private final int age;
    private final String location;

    //创建一个静态类Builder
    public static class Builder {
        //内部类定义自己的age对象，使用final关键字将必须在Builder的构造器中进行赋值
        //如果构造对象的目标参数中有必填的则必须使用final关键字进行修饰
        private final int age;
        //下面的参数为可选参数，如果目标对象的参数都是必填参数使用了final关键字进行修饰，那么这个位置就需要进行默认值设置
        private int high = 0;
        private int weight = 0;
        private String location = "";

        public Builder(int age) {
            this.age = age;
        }

        public Builder weight(int value) {
            this.weight = value;
            return this;
        }

        public Builder high(int value) {
            this.high = value;
            return this;
        }

        public Builder location(String value) {
            this.location = value;
            return this;
        }

        public GirlFriend build() {
            return new GirlFriend(this);
        }
    }

    private GirlFriend(Builder builder) {
        this.age = builder.age;
        this.weight = builder.weight;
        this.high = builder.high;
        this.location = builder.location;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("GirlFriend{");
        sb.append("high=").append(high);
        sb.append(", weight=").append(weight);
        sb.append(", age=").append(age);
        sb.append(", location='").append(location).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
