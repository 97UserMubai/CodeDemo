package com.code.feign;

import com.code.api.OrderApi;
import com.code.config.DefaultFeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * feign客户端，暴露给外部服务进行使用
 *
 * @author mubai
 */

@FeignClient(value = "orderservice", configuration = DefaultFeignConfiguration.class)
public interface OrderClient extends OrderApi {
}
