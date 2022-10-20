package com.client;

public class OfferMetaInfo {
    private String productId;
    private Integer numberOfProduct;
    private Integer offerPrice;

    private Boolean isDependOn;
    private String dependProduct;

    public OfferMetaInfo(String productId, Integer numberOfProduct, Integer offerPrice, Boolean isDependOn, String dependProduct) {
        this.productId = productId;
        this.numberOfProduct = numberOfProduct;
        this.offerPrice = offerPrice;
        this.isDependOn = isDependOn;
        this.dependProduct = dependProduct;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getNumberOfProduct() {
        return numberOfProduct;
    }

    public void setNumberOfProduct(Integer numberOfProduct) {
        this.numberOfProduct = numberOfProduct;
    }

    public Integer getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(Integer offerPrice) {
        this.offerPrice = offerPrice;
    }

    public Boolean getDependOn() {
        return isDependOn;
    }

    public void setDependOn(Boolean dependOn) {
        isDependOn = dependOn;
    }

    public String getDependProduct() {
        return dependProduct;
    }

    public void setDependProduct(String dependProduct) {
        this.dependProduct = dependProduct;
    }
}
