package main.com.boot.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Classname MyClass
 * @Description 用于测试@Autowired注解的源码
 * @Date 2021/9/21 15:38
 * @Created by mubai
 */
@Component
public class MyClass {

    private final MyBean myBean;

    @Autowired
    public MyClass(MyBean myBean) {
        this.myBean = myBean;
    }
}
