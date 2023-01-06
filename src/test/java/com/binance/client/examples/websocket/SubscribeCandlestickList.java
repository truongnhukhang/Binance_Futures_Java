package com.binance.client.examples.websocket;

import com.binance.client.SubscriptionClient;
import com.binance.client.model.enums.CandlestickInterval;

import java.util.Arrays;

public class SubscribeCandlestickList {
    public static void main(String[] args) {
        SubscriptionClient client = SubscriptionClient.create();

        client.subscribeCandlestickEvent(Arrays.asList("btcusdt","ethusdt"), CandlestickInterval.ONE_MINUTE, ((event) -> {
            System.out.println(event);
        }), null);
    }
}
