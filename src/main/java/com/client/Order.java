package com.client;

import java.util.List;

public class Order {

    private List<OrderITem> orderITemList;
    private Integer orderValue;

    public List<OrderITem> getOrderITemList() {
        return orderITemList;
    }

    public void setOrderITemList(List<OrderITem> orderITemList) {
        this.orderITemList = orderITemList;
    }

    public Integer getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(Integer orderValue) {
        this.orderValue = orderValue;
    }
}
