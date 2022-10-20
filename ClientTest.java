package com.client;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ClientTest {

    @Test
    public void testGetOrderValue() {

        OrderITem orderITem = new OrderITem(new Product("A", 50), 1);
        OrderITem orderITem2 = new OrderITem(new Product("B", 30), 1);
        OrderITem orderITem3 = new OrderITem(new Product("C", 20), 1);
        List<OrderITem> orderITemList = new ArrayList<>();
        orderITemList.add(orderITem);
        orderITemList.add(orderITem2);
        orderITemList.add(orderITem3);
        Order order = new Order();
        order.setOrderITemList(orderITemList);
        Assertions.assertEquals(100, new Client().getOrderValue(order, "WrongCoupon"));


    }

    @Test
    public void testGetOrderValue2() {

        OrderITem orderITem = new OrderITem(new Product("A", 50), 5);
        OrderITem orderITem2 = new OrderITem(new Product("B", 30), 5);
        OrderITem orderITem3 = new OrderITem(new Product("C", 20), 1);
        List<OrderITem> orderITemList = new ArrayList<>();
        orderITemList.add(orderITem);
        orderITemList.add(orderITem2);
        orderITemList.add(orderITem3);
        Order order = new Order();
        order.setOrderITemList(orderITemList);
        Assertions.assertEquals(370, new Client().getOrderValue(order, "offer1"));
    }

    @Test
    public void testGetOrderValue3() {

        OrderITem orderITem = new OrderITem(new Product("A", 50), 3);
        OrderITem orderITem2 = new OrderITem(new Product("B", 30), 5);
        OrderITem orderITem3 = new OrderITem(new Product("C", 20), 1);
        OrderITem orderITem4 = new OrderITem(new Product("D", 15), 1);
        List<OrderITem> orderITemList = new ArrayList<>();
        orderITemList.add(orderITem);
        orderITemList.add(orderITem2);
        orderITemList.add(orderITem3);
        orderITemList.add(orderITem4);
        Order order = new Order();
        order.setOrderITemList(orderITemList);
        Assertions.assertEquals(280, new Client().getOrderValue(order, "offer1"));

    }


    private List<Product> prepareProduct() {
        List<Product> products = new ArrayList<>();
        Product p1 = new Product("A", 50);
        Product p2 = new Product("B", 30);
        Product p3 = new Product("C", 20);
        Product p4 = new Product("D", 15);
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        return products;
    }
}
