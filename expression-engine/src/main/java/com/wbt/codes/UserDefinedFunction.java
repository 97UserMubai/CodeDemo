package com.wbt.codes;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorDouble;
import com.googlecode.aviator.runtime.type.AviatorObject;

import java.util.Map;

/**
 * @name: UserDefinedFunction
 * @author: Mubai.Wang
 * @date: 2023/1/29
 * @version: 1.0
 * @description:
 */
public class UserDefinedFunction extends AbstractFunction {
    @Override
    public String getName() {
        return "xiaowang";
    }

    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2) {
        Number left = FunctionUtils.getNumberValue(arg1, env);
        Number right = FunctionUtils.getNumberValue(arg2, env);
        return new AviatorDouble(left.doubleValue() * right.doubleValue());
    }

}
