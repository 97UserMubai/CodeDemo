package com.code.validate;

import java.util.function.Function;

/**
 * @Classname Validator
 * @Description 验证器对象，泛型T表示待验证的对象类型
 * @Date 2022-7-23 15:19
 * @Created by mubai
 */
public interface Validator<T> {

    void validate(ValidatorContext context, T key, Function<T, Boolean> function);


}
