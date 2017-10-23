package net.terzeron.test.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created by terzeron on 2017. 4. 25..
 */
public class DatetimeTest {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today);
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        LocalTime currentTime = LocalTime.now();
        System.out.println(currentTime);

        LocalDate yesterday = LocalDate.of(2016, 2, 9);
        System.out.println(yesterday);
        LocalTime thatTime = LocalTime.of(18, 30, 34);
        System.out.println(thatTime);
        LocalDateTime theDay = LocalDateTime.of(yesterday, thatTime);
        System.out.println(theDay);
        LocalDateTime superDay = LocalDateTime.of(2016, 2, 5, 15, 0, 0);
        System.out.println(superDay);

        LocalDate thatDay = LocalDate.parse("2016-01-04");
        System.out.println(thatDay);
        LocalTime goHomeTime = LocalTime.parse("18:30:00");
        System.out.println(goHomeTime);
        LocalDateTime dayAndTime = LocalDateTime.parse("2016-01-04T18:30:00");
        System.out.println(dayAndTime);
        LocalDate localDate = today.withDayOfMonth(5);
        System.out.println(localDate);

        System.out.println(now.getYear());
        System.out.println(now.getMonthValue());
        System.out.println(now.getDayOfMonth());
    }
}
