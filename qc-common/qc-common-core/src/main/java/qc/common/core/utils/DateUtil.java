package qc.common.core.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 时间日期处理工具类
 *
 * @author QuCheng Tech
 */
public class DateUtil extends org.apache.commons.lang3.time.DateUtils {
    // ==格式到年==
    /**
     * 日期格式，年份，例如：2004，2008
     */
    public static final String DATE_FORMAT_YYYY = "yyyy";


    // ==格式到年月 ==
    /**
     * 日期格式，年份和月份，例如：200707，200808
     */
    public static final String DATE_FORMAT_YYYYMM = "yyyyMM";

    /**
     * 日期格式，年份和月份，例如：200707，2008-08
     */
    public static final String DATE_FORMAT_YYYY_MM = "yyyy-MM";

    /**
     * 日期格式，年月日，例如：050630，080808
     */
    public static final String DATE_FORMAT_YYMMDD = "yyMMdd";

    /**
     * 日期格式，年月日，用横杠分开，例如：06-12-25，08-08-08
     */
    public static final String DATE_FORMAT_YY_MM_DD = "yy-MM-dd";

    /**
     * 日期格式，年月日，例如：20050630，20080808
     */
    public static final String DATE_FORMAT_YYYYMMDD = "yyyyMMdd";

    /**
     * 日期格式，年月日，用横杠分开，例如：2006-12-25，2008-08-08
     */
    public static final String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";

    /**
     * 日期格式，年月日，例如：2016.10.05
     */
    public static final String DATE_FORMAT_POINTYYYYMMDD = "yyyy.MM.dd";

    /**
     * 日期格式，年月日，例如：2016年10月05日
     */
    public static final String DATE_TIME_FORMAT_YYYY年MM月DD日 = "yyyy年MM月dd日";

    /**
     * 日期格式，年月日时分，例如：200506301210，200808081210
     */
    public static final String DATE_FORMAT_YYYYMMDDHHmm = "yyyyMMddHHmm";

    /**
     * 日期格式，年月日时分，例如：20001230 12:00，20080808 20:08
     */
    public static final String DATE_TIME_FORMAT_YYYYMMDD_HH_MI = "yyyyMMdd HH:mm";

    /**
     * 日期格式，年月日时分，例如：2000-12-30 12:00，2008-08-08 20:08
     */
    public static final String DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI = "yyyy-MM-dd HH:mm";

    /**
     * 日期格式，年月日时分，例如：2000-12-30 12，2008-08-08 20
     */
    public static final String DATE_TIME_FORMAT_YYYY_MM_DD_HH  = "yyyy-MM-dd HH";

    // ==格式到年月日 时分秒==
    /**
     * 日期格式，年月日时分秒，例如：20001230120000，20080808200808
     */
    public static final String DATE_TIME_FORMAT_YYYYMMDDHHMISS = "yyyyMMddHHmmss";

    /**
     * 日期格式，年月日时分秒，年月日用横杠分开，时分秒用冒号分开
     * 例如：2005-05-10 23：20：00，2008-08-08 20:08:08
     */
    public static final String DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS = "yyyy-MM-dd HH:mm:ss";


    // ==格式到年月日 时分秒 毫秒==
    /**
     * 日期格式，年月日时分秒毫秒，例如：20001230120000123，20080808200808456
     */
    public static final String DATE_TIME_FORMAT_YYYYMMDDHHMISSSSS = "yyyyMMddHHmmssSSS";


    // ==特殊格式==
    /**
     * 日期格式，月日时分，例如：10-05 12:00
     */
    public static final String DATE_FORMAT_MMDDHHMI = "MM-dd HH:mm";


    /**
     *日期格式，年月日时分秒，例如：2000-12-30 12:00:00，2008-08-08 20:08:00
     */
    public static final String DATE_TIME_FORMAT_YYYYMMDDHHMM= "yyyy/MM/dd HH:mm";

    private static String[] DATE_PARSE_PATTERNS = {
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};

    /**
     * 获取当前Date型日期
     *
     * @return Date() 当前时间
     */
    public static Date getNowDate() {
        return new Date();
    }

    /**
     * 获取当日Date型日期，时分秒均为0
     *
     * @return Date() 当前日期
     */
    public static Date getTodayDate() {
        Date now = getNowDate();
        return newDate(getYear(now), getMonth(now), getDay(now));
    }

    /**
     * 根据指定的年月日得到日期，时分秒均为0
     *
     * @return
     */
    public static Date newDate(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, day);
        return cal.getTime();
    }

    /**
     * 日期型字符串转化为日期 格式
     */
    public static Date parseDate(Object obj) {
        if (obj == null) {
            return null;
        }
        Date date = null;
        try {
            date = parseDate(obj.toString(), DATE_PARSE_PATTERNS);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (date == null) {
            //如果用格式数组转换得到的结果为null表示失败，在此使用中间带有T和Z的时间格式化方法进行一次转换
            try {
                //需要转换的时间
                //String myDateString = "2021-11-02T05:55:14.428Z";
                //进行转化时区
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.getDefault());
                date = dateFormat.parse(obj.toString().replace("Z", "+0000"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return date;
    }

    /***
     *
     * 获取日期格式化字符串，默认为yyyy-MM-dd
     *
     * @param date  日期
     * @return java.lang.String
     * @author QuCheng Tech
     * @date 2022/11/21
     */
    public static String getDateString(Date date) {
        return getString(date,DATE_FORMAT_YYYY_MM_DD);
    }

    /***
     *
     * 获取日期时间格式化字符串，默认为yyyy-MM-dd HH:mm:ss
     *
     * @param date  日期
     * @return java.lang.String
     * @author QuCheng Tech
     * @date 2022/11/21
     */
    public static String getDateTimeString(Date date) {
        return getString(date,DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS);
    }

    /***
     *
     * 获取日期格式化字符串
     *
     * @param date  日期
     * @return java.lang.String
     * @author QuCheng Tech
     * @date 2022/11/21
     */
    public static String getString(Date date, String pattern) {
        return parseDateToStr(date, pattern);
    }

    /***
     * 将指定的date按指定的格式化字符串进行输出
     * @param date, format
     * @return java.lang.String
     * @author QuCheng Tech
     * @date 2022/11/21
     */
    public static final String parseDateToStr(final Date date, final String format) {
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 获取某日期的年份
     * @param date
     * @return
     */
    public static Integer getYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.YEAR);
    }

    /**
     * 获取某日期的月份
     * @param date
     * @return
     */
    public static Integer getMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取某日期的日数
     * @param date
     * @return
     */
    public static Integer getDay(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int day=cal.get(Calendar.DATE);//获取日
        return day;
    }

    /**
     * 获取某个日期为星期几
     * @param date
     * @return String "星期*"
     */
    public static String getDayWeekOfDate1(Date date) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;

        return weekDays[w];
    }
    /**
     * 获得两个日期的时间戳之差
     * @param startDate
     * @param endDate
     * @return
     */
    public static Long getDistanceTimestamp(Date startDate,Date endDate){
        long daysBetween=(endDate.getTime()-startDate.getTime()+1000000)/(3600*24*1000);
        return daysBetween;
    }

    /**
     * 获得两个时间相差距离多少天多少小时多少分多少秒
     * @param one 时间参数 1 格式：1990-01-01 12:00:00
     * @param two 时间参数 2 格式：2009-01-01 12:00:00
     * @return long[] 返回值为：{天, 时, 分, 秒}
     */
    public static long[] getDistanceTime(Date one, Date two) {
        long day = 0;
        long hour = 0;
        long min = 0;
        long sec = 0;
        try {

            long time1 = one.getTime();
            long time2 = two.getTime();
            long diff ;
            if(time1<time2) {
                diff = time2 - time1;
            } else {
                diff = time1 - time2;
            }
            day = diff / (24 * 60 * 60 * 1000);
            hour = (diff / (60 * 60 * 1000) - day * 24);
            min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
            sec = (diff/1000-day*24*60*60-hour*60*60-min*60);
        } catch (Exception e) {
            e.printStackTrace();
        }
        long[] times = {day, hour, min, sec};
        return times;
    }
}
