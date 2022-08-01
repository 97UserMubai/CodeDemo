package com.code.meter;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname ValidatorContext
 * @Description 仪表对象的上下文类，在链式的上下文构造过程中，
 * 对于非阻断式并且需要获取前一个动作执行的结果执行器，可以通过该对象来进行业务代码的下一步操作
 * @Date 2022-7-23 14:53
 * @Created by mubai
 */
public class MeterContext {

    /**
     * 验证器共享使用的属性键值对
     */
    private Map<String, Object> attributes;

    /**
     * 设置属性值
     *
     * @param key   键
     * @param value 值
     */
    public void setAttributes(String key, Object value) {
        if (attributes == null) {
            attributes = new HashMap<>();
        }
        attributes.put(key, value);
    }

    /**
     * 获取属性
     *
     * @param key 键
     * @return 值
     */
    public Object getAttribute(String key) {
        if (attributes != null && !attributes.isEmpty()) {
            return attributes.get(key);
        }
        return null;
    }

    /**
     * 获取 string 类型的值
     *
     * @param key 键
     * @return 值
     */
    public String getString(String key) {
        return (String) getAttribute(key);
    }


    /**
     * 获取 Integer 类型的值
     *
     * @param key 键
     * @return 值
     */
    public Integer getInteger(String key) {
        return (Integer) getAttribute(key);
    }

    /**
     * 获取 Boolean 类型的值
     *
     * @param key 键
     * @return 值
     */
    public Boolean getBoolean(String key) {
        return (Boolean) getAttribute(key);
    }

    /**
     * 获取 Long 类型的值
     *
     * @param key 键
     * @return 值
     */
    public Long getLong(String key) {
        return (Long) getAttribute(key);
    }

    /**
     * 获取 BigDecimal 类型的值
     *
     * @param key 键
     * @return 值
     */
    public BigDecimal getBigDecimal(String key) {
        return (BigDecimal) getAttribute(key);
    }

    /**
     * 获取对象
     *
     * @param key 键
     * @param <T> 泛型T
     * @return 对象
     */
    public <T> T getClazz(String key) {
        return (T) getAttribute(key);
    }


}
