package com.code.meter;

import lombok.extern.slf4j.Slf4j;

/**
 * @Classname MeterBuilder
 * @Description 仪表Builder器，提供链式builder方法，提供执行方法，对链式Operator内容进行执行
 * <pre>
 *     1.链式方法执行过程中调用operator本身的抽象方法进行结果的上下文的封装
 *     2.当前Builder对象的上下文为全局的，所以需要提供上下文获取方法
 * </pre>
 * @Date 2022-7-23 14:44
 * @Created by mubai
 */
@Slf4j
public class MeterBuilder {

    /**
     * 仪表执行器对象列表对象
     */
    private final MeterOperatorElementList meterOperatorElementList = new MeterOperatorElementList();

    /**
     * 执行器上下文
     */
    private MeterContext context = new MeterContext();

    /**
     * 私有构造器，只允许通过builder方法获取构造器对象
     */
    private MeterBuilder() {
    }

    /**
     * 创建MeterBuilder对象
     *
     * @return MeterBuilder对象
     */
    public static MeterBuilder builder() {
        return new MeterBuilder();
    }

    /**
     * 链式补充执行器对象
     *
     * @param operator 执行器对象
     * @param <T>      验证对象泛型
     * @return MeterBuilder对象
     */
    public <T> MeterBuilder on(AbstractOperator<T> operator) {
        meterOperatorElementList.add(new MeterOperatorElement(null, operator));
        return this;
    }

    /**
     * 链式补充执行器对象
     *
     * @param t        验证目标对象
     * @param operator 执行器对象
     * @param <T>      验证对象泛型
     * @return MeterBuilder对象
     */
    public <T> MeterBuilder on(T t, AbstractOperator<T> operator) {
        meterOperatorElementList.add(new MeterOperatorElement(t, operator));
        return this;
    }


    /**
     * 使用验证器验证指定对象，只有当condition为true时才做验证
     *
     * @param t         验证目标对象
     * @param operator  执行器对象
     * @param condition 是否需要验证
     * @param <T>       验证对象泛型
     * @return MeterBuilder对象
     */
    public <T> MeterBuilder on(T t, AbstractOperator<T> operator, boolean condition) {
        if (condition) {
            meterOperatorElementList.add(new MeterOperatorElement(t, operator));
        }
        return this;
    }

    /**
     * 将键值放入上下文
     *
     * @param key   键
     * @param value 值
     * @return MeterBuilder对象
     */
    public MeterBuilder putContext(String key, Object value) {
        if (context == null) {
            context = new MeterContext();
        }
        context.setAttributes(key, value);
        return this;
    }

    /**
     * 获取上下文对象
     *
     * @return 上下文对象
     */
    public MeterContext getContext() {
        return context;
    }

    /**
     * 执行验证器链中的各个验证逻辑
     */
    public MeterBuilder execute() {
        if (meterOperatorElementList.isEmpty()) {
            log.info("Nothing need to execute!");
            return null;
        }
        meterOperatorElementList.getList().forEach(element -> {
            Object key = element.getKey();
            AbstractOperator operator = element.getOperator();
            String operatorName = operator.getClass().getSimpleName();
            log.info("{} is running", operatorName);
            operator.operate(context, key);
        });
        return this;
    }


}
