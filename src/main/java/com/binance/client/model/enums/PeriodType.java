package com.binance.client.model.enums;

import com.binance.client.impl.utils.EnumLookup;

import java.time.Duration;
import java.time.Instant;
import java.time.Period;
import java.time.chrono.ChronoPeriod;
import java.time.temporal.ChronoUnit;

public enum PeriodType {
    _5m("5m"),
    _15m("15m"),
    _30m("30m"),
    _1h("1h"),
    _2h("2h"),
    _4h("4h"),
    _6h("6h"),
    _12h("12h"),
    _1d("1d"),
    n_5m("MINUTE_5"),
    n_15m("MINUTE_15"),
    n_30m("MINUTE_30"),
    n_1h("HOUR_1"),
    n_2h("HOUR_2"),
    n_4h("HOUR_4"),
    n_6h("HOUR_6"),
    n_8h("HOUR_8"),
    n_12h("HOUR_12"),
    n_1d("DAY_1");

    private final String code;

    PeriodType(String code) {
        this.code = code;
    }


    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return code;
    }

    private static final EnumLookup<PeriodType> lookup = new EnumLookup<>(PeriodType.class);

    public static PeriodType lookup(String name) {
        return lookup.lookup(name);
    }
}
