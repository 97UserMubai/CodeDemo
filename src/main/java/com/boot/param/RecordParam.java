package com.boot.param;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @name: RecordParam
 * @author: mubai.
 * @date: 2021/11/26
 * @version: 1.0
 * @description:
 */
@Data
public class RecordParam {

    /**
     * 万
     */
    @NotNull(message = "所有单位数字不能为空")
    private Integer num1;

    /**
     * 千
     */
    @NotNull(message = "所有单位数字不能为空")
    private Integer num2;

    /**
     * 百
     */
    @NotNull(message = "所有单位数字不能为空")
    private Integer num3;

    /**
     * 十
     */
    @NotNull(message = "所有单位数字不能为空")
    private Integer num4;

    /**
     * 个
     */
    @NotNull(message = "所有单位数字不能为空")
    private Integer num5;

    /**
     * 记录key，唯一值
     */
    @NotNull(message = "记录key不能为空")
    private String recordKey;
}
