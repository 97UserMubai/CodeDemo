package com.code.api;

import com.code.entity.OrderDetail;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface OrderApi {
    @GetMapping("getOrderById")
    OrderDetail getOrderById(@RequestParam("orderSerial") String orderSerial);
}
