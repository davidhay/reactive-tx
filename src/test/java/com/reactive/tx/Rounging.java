package com.reactive.tx;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

public class Rounging {

    private static final BigDecimal ONE_THOUSAND = BigDecimal.valueOf(1000);

    LocalDateTime TS_1 = LocalDateTime.parse("2023-09-12T21:14:26.342569123");

    @Test
    void test() {
        System.out.println(LocalDateTime.now());
        int nano = 123124500;

        int micros1 = BigDecimal.valueOf(nano)
                .divide(ONE_THOUSAND)
                .setScale(0, RoundingMode.HALF_EVEN)
                .multiply(ONE_THOUSAND)
                .intValue();

        int micros2 = BigDecimal.valueOf(nano)
                .movePointLeft(3)
                .setScale(0, RoundingMode.HALF_EVEN)
                .movePointRight(3)
                .intValue();

        System.out.println(micros1);
        System.out.println(micros2);
    }
}
