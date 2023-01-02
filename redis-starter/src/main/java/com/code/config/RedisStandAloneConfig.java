package com.code.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @name: RedisConfig
 * @author: mubai.
 * @date: 2022/2/21
 * @version: 1.0
 * @description: <pre>
 *     1.单机模式的redisConfig, 使用ConditionalOnProperty注解来就决定该配置类是否生效
 *     2.除了基础配置之外，对外提供一些基本数据类型操作的对象，都来源于RedisTemplate的opsFor方法
 * </pre>
 */
@Configuration
@ConditionalOnProperty(name = "spring.redis.mode", havingValue = "standAlone")
public class RedisStandAloneConfig {

    /**
     * redisTemplate实例注入，进行相关属性配置
     *
     * @param factory 连接工厂
     * @return RedisTemplate
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        //将连接工厂配置给redisTemplate实例
        template.setConnectionFactory(factory);
        //序列化，默认为string类型
        template.setKeySerializer(new StringRedisSerializer());
        return template;
    }


    /**
     * 获取redis字符串类型操作实例
     *
     * @param redisTemplate redisTemplate
     * @return ValueOperations
     */
    @Bean
    public ValueOperations<String, Object> valueOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForValue();
    }

}
