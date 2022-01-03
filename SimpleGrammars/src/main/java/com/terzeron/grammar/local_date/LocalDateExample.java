package com.terzeron.grammar.local_date;

import java.time.*;

public class LocalDateExample {
    public static void main(String[] args) {
        LocalDateTime time = LocalDateTime.now();
        System.out.println(time.plusDays(3));
        LocalDateTime time2 = time.plusDays(3);

        // 특정 tz의 시각 구하기
        OffsetDateTime time3 = OffsetDateTime.of(LocalDateTime.now(), ZoneOffset.of("+3"));
        System.out.println(time3);
        // 같은 순간에 다른 tz에서 몇 시인지 확인하는 방법
        System.out.println(time3.withOffsetSameInstant(ZoneOffset.of("+9")));
        // tz만 변경함
        System.out.println(time3.withOffsetSameLocal(ZoneOffset.of("+9")));

        ZonedDateTime time4 = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Asia/Seoul"));
        System.out.println(time4);

        int year = 2018;
        String zoneId = "GB";
        for (int month = 1; month <= 12; month++) {
            ZonedDateTime time5 = ZonedDateTime.of(LocalDateTime.of(year, month, 1, 0, 0, 0), ZoneId.of(zoneId));
            System.out.println(time5);
        }
    }
}
