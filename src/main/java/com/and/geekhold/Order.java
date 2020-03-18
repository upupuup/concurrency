package com.and.geekhold;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Description: 订单类
 * @Author: jiangzhihong
 * @CreateDate: 2020/3/18 21:15
 */
public class Order {
    private Long id;
    //顾客ID
    private Long customerId;
    //顾客姓名
    private String customerName;
    //订单商品明细
    private List orderItemList;
    //总价格
    private Double totalPrice;
    //下单时间
    private LocalDateTime placedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List orderItemList) {
        this.orderItemList = orderItemList;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getPlacedAt() {
        return placedAt;
    }

    public void setPlacedAt(LocalDateTime placedAt) {
        this.placedAt = placedAt;
    }
}
