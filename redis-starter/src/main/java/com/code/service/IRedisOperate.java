package com.code.service;

/**
 * @name: IRedisOperate
 * @author: mubai.
 * @date: 2022/2/21
 * @version: 1.0
 * @description: 用于redis调用时需要
 */
public interface IRedisOperate {

    /**
     * 设置指定key的value，不进行校验直接覆盖
     *
     * @param key   key
     * @param value value
     */
    void set(String key, String value);

    /**
     * 获取key对应的value
     *
     * @param key key
     * @return 获取key对应的value
     */
    String get(String key);
}
