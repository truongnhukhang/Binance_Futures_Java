package com.binance.client.model.enums;

import com.binance.client.impl.utils.EnumLookup;

public enum NoticeEventType {
    UP_1("up_1"),
    UP_BREAKTHROUGH("up_breakthrough"),
    DOWN_1("down_1"),
    DOWN_BREAKTHROUGH("down_breakthrough"),
    DROP_BACK("drop_back"),
    RISE_AGAIN("rise_again"),
    ;

    private String code;

    NoticeEventType(String code) {
        this.code = code;
    }

    private static final EnumLookup<NoticeEventType> lookup = new EnumLookup<>(NoticeEventType.class);

    public static NoticeEventType lookup(String name) {
        return lookup.lookup(name);
    }
}
