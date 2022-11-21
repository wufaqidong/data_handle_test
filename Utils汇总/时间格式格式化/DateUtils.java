package cn.com.taiji.lawenforcement.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtils {

    public static String DATE_FORMART = "yyyy-MM-dd";

    public static String DATE_TIME_FORMART = "yyyy-MM-dd HH:mm:ss";

    public static String TIME_FORMART = "HH:mm:ss";

    public static String DATE_TIME_SSS_FORMART = "yyyyMMddHHmmssSSS";

    private static String dateTime;
    private static String format;

    /**
     * 获取格式的时间
     * @param format
     * @return
     */
    public static String getFormatString(String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date());
    }

    /**
     * 格式化时间
     * @param dateTime
     * @param format
     * @return
     */
    public static String formatDate(LocalDateTime dateTime,String format){
        if(dateTime == null){
            return null;
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
        return dtf.format(dateTime);
    }

    /**
     * 格式化时间
     * @param dateTime
     * @param format
     * @return
     */
    public static String formatDate(LocalDate dateTime,String format){
        if(dateTime == null){
            return null;
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
        return dtf.format(dateTime);
    }
    /**
     * 格式化时间
     * @param dateTime
     * @param format
     * @return
     */
    public static Date paseFormatDate(LocalDateTime dateTime,String format){
        if(dateTime == null){
            return null;
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
        return DateUtils.parseDate(dtf.format(dateTime),format);
    }
    /**
     * 格式化时间
     * @param dateTime
     * @param format
     * @return
     */
    public static LocalDate paseFormatLocalDate(LocalDateTime dateTime,String format){
        if(dateTime == null){
            return null;
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
        return DateUtils.getLocalDate(dtf.format(dateTime),format);
    }

    /**
     * 格式化时间
     * @param dateTime
     * @param format
     * @return
     */
    public static String formatDate(Date dateTime,String format){
        if(dateTime == null){
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(dateTime);
    }

    /**
     * 格式化时间
     * @param dateTime
     * @param format
     * @return
     */
    public static Date parseDate(String dateTime,String format){
        if(dateTime == null){
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = sdf.parse(dateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获取格式的时间
     * @param format
     * @return
     */
    public static LocalDateTime getLocalDateTime(String dateTime,String format){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
        return LocalDateTime.parse(dateTime,dtf);
    }

    /**
     * 获取格式的时间
     * @param format
     * @return
     */
    public static LocalDate getLocalDate(String dateTime,String format){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
        return LocalDate.parse(dateTime,dtf);
    }

    /**
     * 获取格式的时间
     * @param localDate
     * @return
     */
    public static LocalDateTime getLocalDateTime(LocalDate localDate){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String format = dtf.format(localDate);
        format += " 00:00:00";
        return getLocalDateTime(format,"yyyy-MM-dd HH:mm:ss");
    }

}
