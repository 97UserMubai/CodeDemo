package com.code.controller;

import com.code.api.OrderApi;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.code.service.IOrderService;
import com.code.entity.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController implements OrderApi {
    @Autowired
    private IOrderService iOrderService;

    @Override
    public OrderDetail getOrderById(String orderSerial) {
        return iOrderService.getOne(new QueryWrapper<OrderDetail>().eq("orderSerial", orderSerial));
    }
}
