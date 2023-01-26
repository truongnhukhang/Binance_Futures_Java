package com.binance.client.model.enums;

import com.binance.client.impl.utils.EnumLookup;

public enum NoticeType {
    PRICE_CHANGE("price_change"),
    PRICE_FLUCTUATION("price_fluctuation"),
    PRICE_BREAKTHROUGH("price_breakthrough");

    private String code;

    NoticeType(String code) {
        this.code = code;
    }
    private static final EnumLookup<NoticeType> lookup = new EnumLookup<>(NoticeType.class);

    public static NoticeType lookup(String name) {
        return lookup.lookup(name);
    }
}
