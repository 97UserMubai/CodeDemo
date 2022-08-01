package com.code.meter;

/**
 * @Classname ValidatorElement
 * @Description 验证器的包装类
 * @Date 2022-7-23 15:14
 * @Created by mubai
 */
public class MeterOperatorElement<T> {

    private T key;

    private AbstractOperator operator;

    public MeterOperatorElement(T key, AbstractOperator operator) {
        this.key = key;
        this.operator = operator;
    }

    public Object getKey() {
        return key;
    }

    public AbstractOperator getOperator() {
        return operator;
    }

}
