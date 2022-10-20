package com.client;

import java.util.Map;
import java.util.Objects;

public class Client {

    private static Map<String, OfferMetaInfo> map;


    public static void main(String[] args) {
        System.out.println("main started");

        System.out.println("main ended");
    }

    public Integer getOrderValue(Order order, String offer) {
        map = Offer.getCouponMap(offer);

        int valueOfOrder = 0;
        boolean flag = false;
        String dependsProduct = "";
        OrderITem itemMutual = null;
        OrderITem itemMutual2 = null;

        if (Objects.nonNull(order) && Objects.nonNull(order.getOrderITemList())) {
            for (OrderITem item : order.getOrderITemList()) {
                if (dependsProduct.equals(item.getProduct().getProductName())) {
                    itemMutual2 = item;
                    flag = true;
                    continue;
                }
                OfferMetaInfo offerMetaInfo = this.getOfferMEtaInfo(item.getProduct().getProductName());
                if (offerMetaInfo != null && !offerMetaInfo.getDependOn()) {
                    valueOfOrder = valueOfOrder + applyOffer(item);
                } else if (offerMetaInfo != null && offerMetaInfo.getDependOn()) {
                    dependsProduct = offerMetaInfo.getDependProduct();
                    itemMutual = item;

                } else {
                    valueOfOrder += item.getQuantity() * item.getProduct().getPrice();
                }
            }
            if (dependsProduct != null && !dependsProduct.isEmpty()) {
                if (flag) {
                    OfferMetaInfo offerMetaInfo = this.getOfferMEtaInfo(itemMutual.getProduct().getProductName());
                    valueOfOrder = valueOfOrder + this.calculateMutulaPrice(itemMutual, offerMetaInfo, itemMutual2);
                } else {
                    valueOfOrder += itemMutual.getQuantity() * itemMutual.getProduct().getPrice();
                }
            }


        }
        order.setOrderValue(valueOfOrder);
        return valueOfOrder;
    }


    public Integer applyOffer(OrderITem orderITem) {
        Product lProduct = orderITem.getProduct();
        Integer lQuantity = orderITem.getQuantity();
        OfferMetaInfo offerMetaInfo = this.getOfferMEtaInfo(lProduct.getProductName());
        if (Objects.nonNull(offerMetaInfo) && lQuantity >= offerMetaInfo.getNumberOfProduct() && !offerMetaInfo.getDependOn()) {
            return calculatePrice(lQuantity, lProduct.getPrice(), offerMetaInfo);

        } else {
            return lProduct.getPrice() * lQuantity;
        }

    }

    private Integer calculatePrice(Integer quantity, Integer price, OfferMetaInfo offerMetaInfo) {

        int qout = quantity / offerMetaInfo.getNumberOfProduct();
        int rem = quantity % offerMetaInfo.getNumberOfProduct();

        return (qout * offerMetaInfo.getOfferPrice()) + (rem * price);

    }

    private OfferMetaInfo getOfferMEtaInfo(String productId) {
        if (this.map != null && null != productId && this.map.containsKey(productId)) {
            return this.map.get(productId);
        }
        return null;
    }

    private int calculateMutulaPrice(OrderITem itemMutual, OfferMetaInfo offerMetaInfo, OrderITem itemMutual2) {
        int q1 = itemMutual.getQuantity();
        int q2 = itemMutual2.getQuantity();

        if (q1 == q2) {
            return q1 * offerMetaInfo.getOfferPrice();
        } else if (q1 > q2) {
            return q2 * offerMetaInfo.getOfferPrice() + (q1 - q2) * itemMutual.getProduct().getPrice();
        } else {
            return q1 * offerMetaInfo.getOfferPrice() + (q2 - q1) * itemMutual2.getProduct().getPrice();
        }
    }


}
