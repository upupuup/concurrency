package com.and.geekhold;

import lombok.Data;

/**
 * @Description: 订单商品类
 * @Author: jiangzhihong
 * @CreateDate: 2020/3/18 22:49
 */
@Data
public class OrderItem {
    //商品ID
    private Long productId;
    //商品名称
    private String productName;
    //商品价格
    private Double productPrice;
    //商品数量
    private Integer productQuantity;
}
