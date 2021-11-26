package com.boot.service;

import com.boot.param.RecordParam;

/**
 * @name: ICaclNumberService
 * @author: mubai.
 * @date: 2021/11/26
 * @version: 1.0
 * @description:
 */
public interface ICalcNumberService {
    /**
     * 进行最新记录存储
     *
     * @param recordParam 入参
     * @return 存储结果
     */
    String saveRecord(RecordParam recordParam);

    String calcRecord();
}
