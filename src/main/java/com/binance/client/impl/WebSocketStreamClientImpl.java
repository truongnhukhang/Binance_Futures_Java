package com.binance.client.impl;

import com.binance.client.SubscriptionClient;
import com.binance.client.SubscriptionErrorHandler;
import com.binance.client.SubscriptionListener;
import com.binance.client.SubscriptionOptions;
import com.binance.client.model.enums.CandlestickInterval;
import com.binance.client.model.event.*;
import com.binance.client.model.user.UserDataUpdateEvent;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class WebSocketStreamClientImpl implements SubscriptionClient {

    private final SubscriptionOptions options;
    private WebSocketWatchDog watchDog;

    private final WebsocketRequestImpl requestImpl;

    private final List<WebSocketConnection> connections = new LinkedList<>();

    WebSocketStreamClientImpl(SubscriptionOptions options) {
        this.watchDog = null;
        this.options = Objects.requireNonNull(options);

        this.requestImpl = new WebsocketRequestImpl();
    }

    private <T> void createConnection(WebsocketRequest<T> request, boolean autoClose) {
        if (watchDog == null) {
            watchDog = new WebSocketWatchDog(options);
        }
        WebSocketConnection connection = new WebSocketConnection(request, watchDog, autoClose);
        if (autoClose == false) {
            connections.add(connection);
        }
        connection.connect();
    }

    private <T> void createConnection(WebsocketRequest<T> request) {
        createConnection(request, false);
    }

    private <T> void createConnection(WebsocketRequest<T> request, String url) {
        if (watchDog == null) {
            watchDog = new WebSocketWatchDog(options);
        }
        WebSocketConnection connection = new WebSocketConnection(request, watchDog, false, url);
        connections.add(connection);
        connection.connect();
    }

    @Override
    public void unsubscribeAll() {
        for (WebSocketConnection connection : connections) {
            watchDog.onClosedNormally(connection);
            connection.close();
        }
        connections.clear();
    }

    @Override
    public void subscribeAggregateTradeEvent(String symbol,
                                             SubscriptionListener<AggregateTradeEvent> subscriptionListener,
                                             SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeAggregateTradeEvent(symbol, subscriptionListener, errorHandler));
    }

    @Override
    public void subscribeAggregateTradeEvent(List<String> symbols,
                                             SubscriptionListener<AggregateTradeEvent> subscriptionListener,
                                             SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeAggregateTradeEvent(symbols, subscriptionListener, errorHandler));
    }

    @Override
    public void subscribeMarkPriceEvent(String symbol,
                                        SubscriptionListener<MarkPriceEvent> subscriptionListener,
                                        SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeMarkPriceEvent(symbol, subscriptionListener, errorHandler));
    }

    @Override
    public void subscribeCandlestickEvent(String symbol, CandlestickInterval interval,
                                          SubscriptionListener<CandlestickEvent> subscriptionListener,
                                          SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeCandlestickEvent(symbol, interval, subscriptionListener, errorHandler));
    }

    @Override
    public void subscribeCandlestickEvent(List<String> symbols, CandlestickInterval interval,
                                          SubscriptionListener<CandlestickEvent> callback, SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeCandlestickEvent(symbols, interval, callback, errorHandler)
        );
    }

    @Override
    public void subscribeSymbolMiniTickerEvent(String symbol,
                                               SubscriptionListener<SymbolMiniTickerEvent> subscriptionListener,
                                               SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeSymbolMiniTickerEvent(symbol, subscriptionListener, errorHandler));
    }

    @Override
    public void subscribeAllMiniTickerEvent(SubscriptionListener<List<SymbolMiniTickerEvent>> subscriptionListener,
                                            SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeAllMiniTickerEvent(subscriptionListener, errorHandler));
    }

    @Override
    public void subscribeSymbolTickerEvent(String symbol,
                                           SubscriptionListener<SymbolTickerEvent> subscriptionListener,
                                           SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeSymbolTickerEvent(symbol, subscriptionListener, errorHandler));
    }

    @Override
    public void subscribeAllTickerEvent(SubscriptionListener<List<SymbolTickerEvent>> subscriptionListener,
                                        SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeAllTickerEvent(subscriptionListener, errorHandler));
    }

    @Override
    public void subscribeSymbolBookTickerEvent(String symbol,
                                               SubscriptionListener<SymbolBookTickerEvent> subscriptionListener,
                                               SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeSymbolBookTickerEvent(symbol, subscriptionListener, errorHandler));
    }

    @Override
    public void subscribeAllBookTickerEvent(SubscriptionListener<SymbolBookTickerEvent> subscriptionListener,
                                            SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeAllBookTickerEvent(subscriptionListener, errorHandler));
    }

    @Override
    public void subscribeSymbolLiquidationOrderEvent(String symbol,
                                                     SubscriptionListener<LiquidationOrderEvent> subscriptionListener,
                                                     SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeSymbolLiquidationOrderEvent(symbol, subscriptionListener, errorHandler));
    }

    @Override
    public void subscribeAllLiquidationOrderEvent(SubscriptionListener<LiquidationOrderEvent> subscriptionListener,
                                                  SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeAllLiquidationOrderEvent(subscriptionListener, errorHandler));
    }

    @Override
    public void subscribeBookDepthEvent(String symbol, Integer limit,
                                        SubscriptionListener<OrderBookEvent> subscriptionListener,
                                        SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeBookDepthEvent(symbol, limit, subscriptionListener, errorHandler));
    }

    @Override
    public void subscribeDiffDepthEvent(String symbol,
                                        SubscriptionListener<OrderBookEvent> subscriptionListener,
                                        SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeDiffDepthEvent(symbol, subscriptionListener, errorHandler));
    }

    @Override
    public void subscribeUserDataEvent(String listenKey,
                                       SubscriptionListener<UserDataUpdateEvent> subscriptionListener,
                                       SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeUserDataEvent(listenKey, subscriptionListener, errorHandler));
    }

    @Override
    public void subscribeAbnormalTradingEvent(SubscriptionListener<AbnormalTradingEvent> callback, SubscriptionErrorHandler errorHandler) {
        createConnection(
                requestImpl.subscribeAbnormalTradingEvent(callback, errorHandler),
                "wss://bstream.binance.com:9443/stream?streams=abnormaltradingnotices"
        );
    }
}
