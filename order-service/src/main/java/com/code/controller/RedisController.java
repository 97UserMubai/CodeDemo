package com.code.controller;

import com.code.service.IRedisOperate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @name: RedisController
 * @author: mubai.
 * @date: 2022/2/21
 * @version: 1.0
 * @description: redis starter启动类测试
 */
@Controller
public class RedisController {

    @Autowired
    private IRedisOperate iRedisOperate;


    @GetMapping("setValue")
    public String setValue(@RequestParam("key") String key, @RequestParam("value") String value) {
        iRedisOperate.set(key, value);
        return "SUCCESS";
    }

    @GetMapping("getValue")
    public String getValue(@RequestParam("key") String key) {
        return iRedisOperate.get(key);
    }
}
