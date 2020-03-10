package com.github.jsjchai.joda;

import org.joda.time.DateTime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * @author jsjchai.
 */
public class JodaTimeExample {

    /**
     * 获取day天后的时间
     */
    public String getDay(Integer day){
        DateTime dateTime = new DateTime();
        // 90天以后的时间
        return dateTime.plusDays(day).toString("E MM/dd/yyyy HH:mm:ss.SSS");
    }

    /**
     *  jdk1.8以后
     */
    public static String getDayByJdk(Integer day){
        DateTimeFormatter pattern =
                DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return now.plus(day, ChronoUnit.DAYS).format(pattern);
    }


}
