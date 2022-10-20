package com.client;

public class Product {

    private String productName;
    private Integer price;

    public String getProductName() {
        return productName;
    }

    public Product(String productName, Integer price) {
        this.productName = productName;
        this.price = price;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
