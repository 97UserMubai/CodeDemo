package com.wbt.codes;

import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * @Classname SpelTest
 * @Description 测试Spel表达式(进行编译文件的观察)
 * @Date 2023-1-17 22:02
 * @Created by mubai
 */
public class SpelTest {
    public static void main(String[] args) {
        SpelExpressionParser spelExpressionParser = new SpelExpressionParser();
        String el = "'i am '.concat(#name).concat(' and my age is ').concat(#age)";
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setVariable("name", "小王");
        context.setVariable("age", "18");
        String elResult = spelExpressionParser.parseExpression(el).getValue(context, String.class);
        System.out.println(elResult);
    }
}
