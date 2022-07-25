package com.code.validate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname ValidatorContext
 * @Description 验证器在执行过程中可以共享的上下文对象，验证的结果支持在该对象中缓存用于后置使用
 * @Date 2022-7-23 14:53
 * @Created by mubai
 */
public class ValidatorContext {

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
        //todo  这个位置需要引入单例模式
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
