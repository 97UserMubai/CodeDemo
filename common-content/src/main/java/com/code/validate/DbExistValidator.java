package com.code.validate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * @name: DbExistValidator
 * @author: mubai.
 * @date: 2022/7/25
 * @version: 1.0
 * @description: 数据库公用的已存在数据的校验
 */
@Component
@Slf4j
public class DbExistValidator<T> implements Validator<T> {

    @Override
    public void validate(ValidatorContext context, T key, Function<T, Boolean> function) {
        boolean existData = function.apply(key);
        context.setAttributes((String) key, existData);
        if (existData) {
            //存在db数据
            log.error("数据库已存在该数据");
        }
    }

}
