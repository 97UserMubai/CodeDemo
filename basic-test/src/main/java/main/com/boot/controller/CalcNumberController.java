package main.com.boot.controller;

import main.com.boot.param.RecordParam;
import main.com.boot.service.ICalcNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @name: CalcNumberController
 * @author: mubai.
 * @date: 2021/11/26
 * @version: 1.0
 * @description:
 */
@RestController
@RequestMapping("calc/number")
public class CalcNumberController {
    @Autowired
    private ICalcNumberService iCalcNumberService;

    /**
     * 进行最新记录存储
     *
     * @param recordParam 入参
     * @return 存储结果
     */
    @PostMapping(value = "save")
    public String saveRecord(@RequestBody @Validated RecordParam recordParam) {
        return iCalcNumberService.saveRecord(recordParam);
    }

    /**
     * 进行数据计算和预测
     *
     * @return 返回计算结果
     */
    @GetMapping(value = "calc")
    public String calcRecord() {
        return iCalcNumberService.calcRecord();
    }
}
