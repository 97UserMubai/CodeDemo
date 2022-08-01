package com.code.meter;

/**
 * @Classname IMeter 仪表需要通用执行的接口
 * @Description 用于校验该动作是否满足执行要求的统一验证方法，这个位置可以接入FluentValidator验证,提供Function类型的验证入口
 * @Date 2022-7-23 15:19
 * @Created by mubai.wang
 */
public interface IMeter<T> {

    boolean check(MeterContext context, T key);

}
