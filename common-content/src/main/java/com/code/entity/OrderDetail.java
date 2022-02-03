package com.code.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 订单表实体
 * </p>
 *
 * @author mubai
 * @since 2022-02-02
 */
@Data
@EqualsAndHashCode
@Accessors(chain = true)
@TableName(value = "order_detail")
public class OrderDetail implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("orderSerial")
    private String orderSerial;

    @TableField("orderOwner")
    private String orderOwner;

    @TableField("orderAmount")
    private BigDecimal orderAmount;

    @TableField("createTime")
    private LocalDateTime createTime;
}
