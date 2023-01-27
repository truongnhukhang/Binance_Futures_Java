package com.binance.client.model.event;

import com.binance.client.model.enums.NoticeEventType;
import com.binance.client.model.enums.NoticeType;
import com.binance.client.model.enums.PeriodType;

public class AbnormalTradingEvent {
    String symbol;

    NoticeType noticeType;

    NoticeEventType noticeEventType;

    double priceChange;

    PeriodType period;

    String baseAsset;

    String quotaAsset;

    long sendTimeStamp;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public NoticeType getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(NoticeType noticeType) {
        this.noticeType = noticeType;
    }

    public NoticeEventType getNoticeEventType() {
        return noticeEventType;
    }

    public void setNoticeEventType(NoticeEventType noticeEventType) {
        this.noticeEventType = noticeEventType;
    }

    public double getPriceChange() {
        return priceChange;
    }

    public void setPriceChange(double priceChange) {
        this.priceChange = priceChange;
    }

    public PeriodType getPeriod() {
        return period;
    }

    public void setPeriod(PeriodType period) {
        this.period = period;
    }

    public String getBaseAsset() {
        return baseAsset;
    }

    public void setBaseAsset(String baseAsset) {
        this.baseAsset = baseAsset;
    }

    public String getQuotaAsset() {
        return quotaAsset;
    }

    public void setQuotaAsset(String quotaAsset) {
        this.quotaAsset = quotaAsset;
    }

    public long getSendTimeStamp() {
        return sendTimeStamp;
    }

    public void setSendTimeStamp(long sendTimeStamp) {
        this.sendTimeStamp = sendTimeStamp;
    }

    @Override
    public String toString() {
        return "AbnormalTradingEvent{" +
                "symbol='" + symbol + '\'' +
                ", noticeType=" + noticeType +
                ", noticeEventType=" + noticeEventType +
                ", priceChange=" + priceChange +
                ", period=" + period +
                ", baseAsset='" + baseAsset + '\'' +
                ", quotaAsset='" + quotaAsset + '\'' +
                ", sendTimeStamp=" + sendTimeStamp +
                '}';
    }
}
