package com.code.validate;

import java.util.function.Function;

/**
 * @Classname ValidatorElement
 * @Description 验证器的包装类
 * @Date 2022-7-23 15:14
 * @Created by mubai
 */
public class ValidatorElement<T> {

    private T target;

    private Function<T, Boolean> function;

    private Validator validator;

    public ValidatorElement(T target, Validator validator, Function<T, Boolean> function) {
        this.target = target;
        this.validator = validator;
        this.function = function;
    }

    public Object getTarget() {
        return target;
    }

    public Validator getValidator() {
        return validator;
    }

    public Function<T, Boolean> getFunction() {
        return function;
    }
}
