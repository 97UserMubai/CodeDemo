package com.code.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.code.entity.OrderDetail;
import com.code.mapper.OrderMapper;
import com.code.service.IOrderService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author mubai
 * @since 2022-02-02
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, OrderDetail> implements IOrderService {

}
