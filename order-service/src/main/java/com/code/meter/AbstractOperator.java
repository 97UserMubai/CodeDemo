package com.code.meter;

/**
 * @Classname AbstarctOperator
 * @Description 抽象的仪表执行动作，提供公共的抽象方法：operate
 * @Date 2022-8-1 14:29
 * @Created by mubai
 */
public abstract class AbstractOperator<T> implements IMeter<T> {

    abstract void operate(MeterContext context, T key);

}
