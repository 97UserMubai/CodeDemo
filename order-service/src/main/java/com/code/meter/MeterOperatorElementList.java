package com.code.meter;

import java.util.LinkedList;

/**
 * @Classname ValidatorElementList
 * @Description TODO
 * @Date 2022-7-23 15:32
 * @Created by mubai
 */
public class MeterOperatorElementList {

    /**
     * 验证器链表
     */
    private LinkedList<MeterOperatorElement> meterOperatorElements = new LinkedList<>();

    /**
     * 将验证器加入链表
     *
     * @param element 验证器
     */
    public void add(MeterOperatorElement element) {
        meterOperatorElements.add(element);
    }

    /**
     * 获取验证器链表
     */
    public LinkedList<MeterOperatorElement> getList() {
        return meterOperatorElements;
    }

    /**
     * 验证器链表是否为空
     */
    public boolean isEmpty() {
        return meterOperatorElements.isEmpty();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        meterOperatorElements.forEach(element -> {
            sb.append("[");
            sb.append(element.getOperator().getClass().getSimpleName());
            sb.append("]->");
        });
        return sb.toString();
    }
}
