package com.code.controller;

import com.code.entity.OrderDetail;
import com.code.feign.OrderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignTestController {

    @Autowired
    private OrderClient orderClient;

    @GetMapping("getOrderDetailByFeign")
    public OrderDetail getOrderDetailByFeign(@RequestParam("orderSerial") String orderSerial) {
        return orderClient.getOrderById(orderSerial);
    }
}
