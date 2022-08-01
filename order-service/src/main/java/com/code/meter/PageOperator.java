package com.code.meter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @name: DbExistValidator
 * @author: mubai.
 * @date: 2022/7/25
 * @version: 1.0
 * @description: 数据库公用的已存在数据的校验
 */
@Component
@Slf4j
public class PageOperator<T> extends AbstractOperator<T> {

    @Override
    public boolean check(MeterContext context, T key) {
        return true;
    }

    @Override
    void operate(MeterContext context, T key) {
        if (check(context, key)) {
            //进行业务代码的实现,这里可以进行try-catch
            List<String> result = new ArrayList<>();
            result.add("测试列表1");
            result.add("测试列表2");
            result.add("测试列表3");
            context.setAttributes((String) key, result);
        } else {
            log.error("未知异常:{}", new RuntimeException("未知异常"));
        }

    }
}
