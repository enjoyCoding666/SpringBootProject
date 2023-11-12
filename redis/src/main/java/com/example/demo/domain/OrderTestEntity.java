package com.example.demo.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 示例表
 * </p>
 *
 * @author xx
 * @since 2023-11-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_order_test")
public class OrderTestEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键,自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 订单号,唯一
     */
    private String orderId;

    /**
     * 10：未支付,20：支付成功,30：支付失败, 40：已下单,50：申请退款,60：退款成功,70：退款失败
     */
    private Integer payStatus;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 交易金额
     */
    private BigDecimal totalPrice;

    /**
     * 结果
     */
    private String result;

    /**
     * 订单描述
     */
    private String orderDesc;

    /**
     * 订单日期
     */
    private Date orderDate;

    /**
     * 创建时间，默认当前时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新时间，更新时默认当前时间
     */
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;

    /**
     * 是否删除,0表示否,1表示是
     */
    @TableLogic
    private Boolean isDelete;


}
