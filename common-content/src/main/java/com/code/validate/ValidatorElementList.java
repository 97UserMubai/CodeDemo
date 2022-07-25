package com.code.validate;

import java.util.LinkedList;

/**
 * @Classname ValidatorElementList
 * @Description TODO
 * @Date 2022-7-23 15:32
 * @Created by mubai
 */
public class ValidatorElementList {

    /**
     * 验证器链表
     */
    private LinkedList<ValidatorElement> validatorElementLinkedList = new LinkedList<>();


    /**
     * 将验证器加入链表
     *
     * @param element 验证器
     */
    public void add(ValidatorElement element) {
        validatorElementLinkedList.add(element);
    }

    /**
     * 获取验证器链表
     */
    public LinkedList<ValidatorElement> getList() {
        return validatorElementLinkedList;
    }

    /**
     * 验证器链表是否为空
     */
    public boolean isEmpty() {
        return validatorElementLinkedList.isEmpty();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        validatorElementLinkedList.forEach(element -> {
            sb.append("[");
            sb.append(element.getValidator().getClass().getSimpleName());
            sb.append("]->");
        });
        return sb.toString();
    }
}
