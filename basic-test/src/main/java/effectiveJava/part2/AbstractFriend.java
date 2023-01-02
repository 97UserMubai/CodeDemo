package effectiveJava.part2;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * @Classname AbstractFriend
 * @Description 类层次的Builder构造器
 * <pre>
 *     该案例结合抽象类一起使用，利用抽象类提供的父类动态继承的特性，将公共的属性交给父类的builder器进行处理
 *     这个位置要注意：沿用单个类的构造器思想，抽象类也可以拥有自己的构造器，由于抽象类本身不支持this关键字的return
 *     所以抽象类的构造器需要使用递归泛型(extend Builder<T>)，通过定义self抽象方法让子类进行重写，子类的泛型返回值为其本身
 *     这样就能在使用构造器的链式调用的同时，使用父类的构造器就行赋值，并用自己的构造器进行本身属性的加工
 * </pre>
 * @Date 2022-10-30 10:11
 * @Created by mubai
 */
public abstract class AbstractFriend {
    //定义一些朋友类型枚举值,回想抽象类的特性，在抽象类中定义了基础属性，子类可以动态使用父类的属性
    public enum Sex {BOY, GIRL, NONE, NORMAL}

    final Set<Sex> sexes;

    //抽象的静态内部构造类，这个位置使用了泛型，并且是一个extends的递归类型参数，从而支持在下面调用self方法时，直接进行子类的方法链接，不需要转换类型
    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Sex> sexes = EnumSet.noneOf(Sex.class);

        //该方法为抽象类自己属性的builder加工方法，如果有多个属性就需要有匹配的多个属性
        public T addSex(Sex sex) {
            sexes.add(Objects.requireNonNull(sex));
            //return this ; 这个位置和单类的Builder不一样，在抽象类中没有this关键字，所以需要定义一个self方法来返回指定的当前对象
            return self();
        }

        abstract AbstractFriend build();

        protected abstract T self();
    }

    AbstractFriend(Builder<?> builder) {
        //todo 这个位置针对枚举值为啥要使用clone方法？
        sexes = builder.sexes.clone();
    }
}
