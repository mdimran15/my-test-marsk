package com.client;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Offer {

    private static Map<String, Map<String, OfferMetaInfo>> map = new HashMap<>();

    private static Lock lock = new ReentrantLock();

    public static Map<String, OfferMetaInfo> getCouponMap(String coupon) {

        if (map.size() == 0) {
            try {
                lock.lock();
                Offer.loadOffer();
            }finally {
                lock.unlock();
            }
        }
        return map.get(coupon);
    }

    private static void loadOffer() {
        Map<String, OfferMetaInfo> lmap = new HashMap<>();
        lmap.put("A", new OfferMetaInfo("A", 3, 130, false, ""));
        lmap.put("B", new OfferMetaInfo("B", 2, 45, false, ""));
        lmap.put("C", new OfferMetaInfo("C", 1, 30, true, "D"));
        lmap.put("D", new OfferMetaInfo("D", 1, 30, true, "C"));

        map.put("offer1", lmap);

    }
}
