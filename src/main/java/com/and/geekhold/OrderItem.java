package com.and.geekhold;

import lombok.Data;

/**
 * @Description: 订单商品类
 * @Author: jiangzhihong
 * @CreateDate: 2020/3/18 22:49
 */
public class OrderItem {
    //商品ID
    private Long productId;
    //商品名称
    private String productName;
    //商品价格
    private Double productPrice;
    //商品数量
    private Integer productQuantity;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }
}
