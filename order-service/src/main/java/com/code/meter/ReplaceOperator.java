package com.code.meter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Classname ReplaceOperator
 * @Description 换表执行器
 * @Date 2022-8-1 15:40
 * @Created by mubai
 */
@Component
@Slf4j
public class ReplaceOperator<T> extends AbstractOperator<T> {
    @Override
    void operate(MeterContext context, T key) {
        context.setAttributes((String) key, "这是一个换表的测试结果");
    }

    @Override
    public boolean check(MeterContext context, T key) {
        return true;
    }
}
