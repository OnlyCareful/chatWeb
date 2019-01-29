package com.chatweb.only.uitl;

import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 * @author InnerConc
 * @date 2019/01/29
 */
public class DateUitl {
    private static Calendar calendar;
    private static SimpleDateFormat simpleDateFormat;

    static {
        calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        simpleDateFormat = new SimpleDateFormat(DateFormatPattern.DEFAULT.getFormat());
    }

    /**
     * 设置时间格式
     * @param date 要格式化的时间
     * @param pattern 指定格式（为空则默认yyyy-MM-dd HH:mm:ss）
     * @return String
     */
    public static String format(Date date, String pattern){
        if (StringUtils.isNotBlank(pattern)){
            simpleDateFormat.applyPattern(pattern);
        }
        return simpleDateFormat.format(date);
    }

    /**
     * 默认格式当前时间
     * @return String
     */
    public static String currentTime(){
        return format(new Date(), null);
    }

    /**
     * 指定格式当前时间
     * @param pattern 指定格式
     * @return String
     */
    public static String currentTime(String pattern){
        return format(new Date(), pattern);
    }

    /**
     * 毫秒数转换为默认时间格式
     * @param millisecond 毫秒数
     * @return String
     */
    public static String millisecond(long millisecond){
        return format(new Date(millisecond), null);
    }

    /**
     * 毫秒数转换为指定时间格式
     * @param millisecond 毫秒数
     * @param pattern 指定格式
     * @return String
     */
    public static String millisecond(long millisecond, String pattern){
        return format(new Date(millisecond), pattern);
    }

    /**
     * 获取指定时间的日历字段（年、月、日......）
     * @param date 指定时间
     * @param field Calendar类中的域
     * @return int
     */
    public static int getDateField(Date date, int field){
        calendar.setTime(date);
        return calendar.get(field);
    }

    /**
     * 年
     * @param date 指定时间
     * @return int
     */
    public static int getYear(Date date){
        return getDateField(date, Calendar.YEAR);
    }

    /**
     * 月
     * @param date 指定时间
     * @return int
     */
    public static int getMonth(Date date){
        return getDateField(date, Calendar.MONTH);
    }

    /**
     * 日
     * @param date 指定时间
     * @return int
     */
    public static int getDay(Date date){
        return getDateField(date, Calendar.DAY_OF_MONTH);
    }

    public enum DateFormatPattern{
        /**
         * 默认时间格式
         */
        DEFAULT("yyyy-MM-dd HH:mm:ss");

        private String format;

        DateFormatPattern(String format) {
            this.format = format;
        }

        public String getFormat() {
            return format;
        }

        @Override
        public String toString() {
            return "DateFormatPattern{" +
                    "format='" + format + '\'' +
                    '}';
        }
    }
}
