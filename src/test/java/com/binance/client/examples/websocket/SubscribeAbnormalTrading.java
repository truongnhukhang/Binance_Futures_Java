package com.binance.client.examples.websocket;

import com.binance.client.SubscriptionClient;

public class SubscribeAbnormalTrading {
    public static void main(String[] args) {
        SubscriptionClient client = SubscriptionClient.create();
        client.subscribeAbnormalTradingEvent(t -> {
            System.out.println(t.toString());
        }, System.out::println);
    }
}
