package com.binance.client.examples.websocket;

import com.binance.client.SubscriptionClient;

public class SubscribeBookDepth {

    public static void main(String[] args) {

        SubscriptionClient client = SubscriptionClient.create();
   
        client.subscribeBookDepthEvent("btcusdt", 10, (System.out::println), null);

    }

}
