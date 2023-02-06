package com.wbt.codes;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;

import java.util.HashMap;
import java.util.Map;

/**
 * @name: AviatorTest
 * @author: Mubai.Wang
 * @date: 2023/1/29
 * @version: 1.0
 * @description: aviator测试
 */
public class AviatorTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException {
        System.out.println(AviatorEvaluator.execute("1+2+3"));
        System.out.println(AviatorEvaluator.execute("3 > 1 && 2!=4 || true"));
        System.out.println((String) AviatorEvaluator.execute("3 > 0 ? yes : no"));
        System.out.println("string.length('hello') = " + AviatorEvaluator.execute("string.length('hello')"));
        System.out.println("string.contains('hello', 'h') = " + AviatorEvaluator.execute("string.contains('hello', 'h')"));
        System.out.println("math.pow(-3, 2) = " + AviatorEvaluator.execute("math.pow(-3, 2)"));
        System.out.println("math.sqrt(9.0) = " + AviatorEvaluator.execute("math.sqrt(9.0)"));
        //添加自定义函数
        AviatorEvaluator.addFunction(new UserDefinedFunction());
        System.out.println("xiaowang(2,4) = " + AviatorEvaluator.execute("xiaowang(2,4)"));
        //进行预编译的测试
        String expression = "a * (b + c)";
        Map<String, Object> env = new HashMap<>();
        env.put("a", 3.32);
        env.put("b", 234);
        env.put("c", 324.2);
        //编译表达式
        Expression compliedExp = AviatorEvaluator.compile(expression);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            Double result = (Double) compliedExp.execute(env);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("预编译的耗时为：" + (endTime - startTime));
        long startTime2 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            Double result = (Double) AviatorEvaluator.execute(expression, env);
        }
        long endTime2 = System.currentTimeMillis();
        System.out.println("无编译的耗时为：" + (endTime2 - startTime2));

        Student student = new Student(1, "xiaowang");
        env.put("student", student);
        AviatorEvaluator.addInstanceFunctions("Student", Student.class);
        System.out.println(AviatorEvaluator.execute("Student.getName(student) == 'xiaowang'", env));

    }
}
