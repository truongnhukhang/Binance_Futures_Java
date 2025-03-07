package com.binance.client;

import java.util.List;

import com.binance.client.impl.BinanceApiInternalFactory;
import com.binance.client.model.enums.CandlestickInterval;
import com.binance.client.model.event.*;
import com.binance.client.model.user.UserDataUpdateEvent;

/***
 * The subscription client interface, it is used for subscribing any market data
 * update and account change, it is asynchronous, so you must implement the
 * SubscriptionListener interface. The server will push any update to the
 * client. if client get the update, the onReceive method will be called.
 */
public interface SubscriptionClient {
    /**
     * Create the subscription client to subscribe the update from server.
     *
     * @return The instance of synchronous client.
     */
    static SubscriptionClient create() {
        return create(new SubscriptionOptions());
    }

    /**
     * Create the subscription client to subscribe the update from server.
     *
     * @param subscriptionOptions The option of subscription connection, see
     *                            {@link SubscriptionOptions}
     * @return The instance of synchronous client.
     */
    static SubscriptionClient create(SubscriptionOptions subscriptionOptions) {
        return BinanceApiInternalFactory.getInstance().createSubscriptionClient(subscriptionOptions);
    }

    /**
     * Unsubscribe all subscription.
     */
    void unsubscribeAll();

    /**
     * Subscribe aggregate trade event. If the aggregate trade is updated,
     * server will send the data to client and onReceive in callback will be called.
     *
     * @param symbol      The symbol, like "btcusdt".
     * @param callback     The implementation is required. onReceive will be called
     *                     if receive server's update.
     * @param errorHandler The error handler will be called if subscription failed
     *                     or error happen between client and Binance server.
     */
    void subscribeAggregateTradeEvent(String symbol,
            SubscriptionListener<AggregateTradeEvent> callback, SubscriptionErrorHandler errorHandler);

    /**
     * Subscribe aggregate trade event. If the aggregate trade is updated,
     * server will send the data to client and onReceive in callback will be called.
     *
     * @param symbols      The symbol list, like Arrays.asList("btcusdt","ethusdt).
     * @param callback     The implementation is required. onReceive will be called
     *                     if receive server's update.
     * @param errorHandler The error handler will be called if subscription failed
     *                     or error happen between client and Binance server.
     */
    void subscribeAggregateTradeEvent(List<String> symbols,
                                      SubscriptionListener<AggregateTradeEvent> callback, SubscriptionErrorHandler errorHandler);

    /**
     * Subscribe mark price event. If the mark price is updated,
     * server will send the data to client and onReceive in callback will be called.
     *
     * @param symbol      The symbol, like "btcusdt".
     * @param callback     The implementation is required. onReceive will be called
     *                     if receive server's update.
     * @param errorHandler The error handler will be called if subscription failed
     *                     or error happen between client and Binance server.
     */
    void subscribeMarkPriceEvent(String symbol,
            SubscriptionListener<MarkPriceEvent> callback, SubscriptionErrorHandler errorHandler);

    /**
     * Subscribe candlestick event. If the candlestick is updated,
     * server will send the data to client and onReceive in callback will be called.
     *
     * @param symbol      The symbol, like "btcusdt".
     * @param interval      The candlestick interval, like "ONE_MINUTE".
     * @param callback     The implementation is required. onReceive will be called
     *                     if receive server's update.
     * @param errorHandler The error handler will be called if subscription failed
     *                     or error happen between client and Binance server.
     */
    void subscribeCandlestickEvent(String symbol, CandlestickInterval interval,
            SubscriptionListener<CandlestickEvent> callback, SubscriptionErrorHandler errorHandler);



    void subscribeCandlestickEvent(List<String> symbols, CandlestickInterval interval,
                                   SubscriptionListener<CandlestickEvent> callback, SubscriptionErrorHandler errorHandler);


    /**
     * Subscribe individual symbol mini ticker event. If the symbol mini ticker is updated,
     * server will send the data to client and onReceive in callback will be called.
     *
     * @param symbol      The symbol, like "btcusdt".
     * @param callback     The implementation is required. onReceive will be called
     *                     if receive server's update.
     * @param errorHandler The error handler will be called if subscription failed
     *                     or error happen between client and Binance server.
     */
    void subscribeSymbolMiniTickerEvent(String symbol,
            SubscriptionListener<SymbolMiniTickerEvent> callback, SubscriptionErrorHandler errorHandler);

    /**
     * Subscribe all market mini tickers event. If the mini tickers are updated,
     * server will send the data to client and onReceive in callback will be called.
     *
     * @param callback     The implementation is required. onReceive will be called
     *                     if receive server's update.
     * @param errorHandler The error handler will be called if subscription failed
     *                     or error happen between client and Binance server.
     */
    void subscribeAllMiniTickerEvent(SubscriptionListener<List<SymbolMiniTickerEvent>> callback, SubscriptionErrorHandler errorHandler);

    /**
     * Subscribe individual symbol ticker event. If the symbol ticker is updated,
     * server will send the data to client and onReceive in callback will be called.
     *
     * @param symbol      The symbol, like "btcusdt".
     * @param callback     The implementation is required. onReceive will be called
     *                     if receive server's update.
     * @param errorHandler The error handler will be called if subscription failed
     *                     or error happen between client and Binance server.
     */
    void subscribeSymbolTickerEvent(String symbol,
            SubscriptionListener<SymbolTickerEvent> callback, SubscriptionErrorHandler errorHandler);

    /**
     * Subscribe all market tickers event. If the tickers are updated,
     * server will send the data to client and onReceive in callback will be called.
     *
     * @param callback     The implementation is required. onReceive will be called
     *                     if receive server's update.
     * @param errorHandler The error handler will be called if subscription failed
     *                     or error happen between client and Binance server.
     */
    void subscribeAllTickerEvent(SubscriptionListener<List<SymbolTickerEvent>> callback, SubscriptionErrorHandler errorHandler);

    /**
     * Subscribe individual symbol book ticker event. If the symbol book ticker is updated,
     * server will send the data to client and onReceive in callback will be called.
     *
     * @param symbol      The symbol, like "btcusdt".
     * @param callback     The implementation is required. onReceive will be called
     *                     if receive server's update.
     * @param errorHandler The error handler will be called if subscription failed
     *                     or error happen between client and Binance server.
     */
    void subscribeSymbolBookTickerEvent(String symbol,
            SubscriptionListener<SymbolBookTickerEvent> callback, SubscriptionErrorHandler errorHandler);

    /**
     * Subscribe all market book tickers event. If the book tickers are updated,
     * server will send the data to client and onReceive in callback will be called.
     *
     * @param callback     The implementation is required. onReceive will be called
     *                     if receive server's update.
     * @param errorHandler The error handler will be called if subscription failed
     *                     or error happen between client and Binance server.
     */
    void subscribeAllBookTickerEvent(SubscriptionListener<SymbolBookTickerEvent> callback, SubscriptionErrorHandler errorHandler);

    /**
     * Subscribe individual symbol book ticker event. If the symbol book ticker is updated,
     * server will send the data to client and onReceive in callback will be called.
     *
     * @param symbol      The symbol, like "btcusdt".
     * @param callback     The implementation is required. onReceive will be called
     *                     if receive server's update.
     * @param errorHandler The error handler will be called if subscription failed
     *                     or error happen between client and Binance server.
     */
    void subscribeSymbolLiquidationOrderEvent(String symbol,
            SubscriptionListener<LiquidationOrderEvent> callback, SubscriptionErrorHandler errorHandler);

    /**
     * Subscribe all market book tickers event. If the book tickers are updated,
     * server will send the data to client and onReceive in callback will be called.
     *
     * @param callback     The implementation is required. onReceive will be called
     *                     if receive server's update.
     * @param errorHandler The error handler will be called if subscription failed
     *                     or error happen between client and Binance server.
     */
    void subscribeAllLiquidationOrderEvent(SubscriptionListener<LiquidationOrderEvent> callback, SubscriptionErrorHandler errorHandler);

    /**
     * Subscribe partial book depth event. If the book depth is updated,
     * server will send the data to client and onReceive in callback will be called.
     *
     * @param symbol      The symbol, like "btcusdt".
     * @param limit         The limit.
     * @param callback     The implementation is required. onReceive will be called
     *                     if receive server's update.
     * @param errorHandler The error handler will be called if subscription failed
     *                     or error happen between client and Binance server.
     */
    void subscribeBookDepthEvent(String symbol, Integer limit,
            SubscriptionListener<OrderBookEvent> callback, SubscriptionErrorHandler errorHandler);

    /**
     * Subscribe diff depth event. If the book depth is updated,
     * server will send the data to client and onReceive in callback will be called.
     *
     * @param symbol      The symbol, like "btcusdt".
     * @param callback     The implementation is required. onReceive will be called
     *                     if receive server's update.
     * @param errorHandler The error handler will be called if subscription failed
     *                     or error happen between client and Binance server.
     */
    void subscribeDiffDepthEvent(String symbol,
            SubscriptionListener<OrderBookEvent> callback, SubscriptionErrorHandler errorHandler);

    /**
     * Subscribe user data event. If the user data is updated,
     * server will send the data to client and onReceive in callback will be called.
     *
     * @param listenKey      The listenKey.
     * @param callback     The implementation is required. onReceive will be called
     *                     if receive server's update.
     * @param errorHandler The error handler will be called if subscription failed
     *                     or error happen between client and Binance server.
     */
    void subscribeUserDataEvent(String listenKey,
            SubscriptionListener<UserDataUpdateEvent> callback, SubscriptionErrorHandler errorHandler);


    void subscribeAbnormalTradingEvent(SubscriptionListener<AbnormalTradingEvent> callback, SubscriptionErrorHandler errorHandler);

}
