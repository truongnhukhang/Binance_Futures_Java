package com.binance.client.examples.market;

import com.binance.client.RequestOptions;
import com.binance.client.SyncRequestClient;

import com.binance.client.examples.constants.PrivateConfig;
import com.binance.client.model.market.OrderBook;
import com.binance.client.model.market.OrderBookEntry;

import java.util.Comparator;

public class GetOrderBook {
    public static void main(String[] args) {
        RequestOptions options = new RequestOptions();
        SyncRequestClient syncRequestClient = SyncRequestClient.create(PrivateConfig.API_KEY, PrivateConfig.SECRET_KEY,
                options);
        OrderBook ob = syncRequestClient.getOrderBook("BTCUSDT", 1000);
        OrderBookEntry maxBid = ob.getBids().stream().max(Comparator.comparing(OrderBookEntry::getQty)).get();
        OrderBookEntry maxAsk = ob.getAsks().stream().max(Comparator.comparing(OrderBookEntry::getQty)).get();
        System.out.println("------------------");
        System.out.println(String.format("Lowest bid : %s",maxBid));
        System.out.println(String.format("max Ask : %s",maxAsk));
    }
}
