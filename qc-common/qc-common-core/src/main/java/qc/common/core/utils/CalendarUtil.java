package qc.common.core.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * CalendarUtil
 *
 * @author QuCheng Tech
 */
public class CalendarUtil {
    /*
     *获取当前时间
     */
    public static Calendar GetNow(){
        return Calendar.getInstance();
    }

    /*
     *获取今日
     */
    public static Calendar GetToday(){
        Calendar cal=GetNow();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);

        return cal;
    }

    /*
     *获取当月
     */
    public static Calendar GetMonth(){
        Calendar cal=GetNow();
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);

        return cal;
    }

    /*
     *获取当年
     */
    public static Calendar GetYear(){
        Calendar cal=GetNow();
        cal.set(Calendar.MONTH, 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);

        return cal;
    }

    public static Calendar AddYears(Calendar calendar,int years){
        calendar.add(Calendar.YEAR,years);
        return calendar;
    }

    public static Calendar AddMonths(Calendar calendar,int month){
        calendar.add(Calendar.MONTH,month);
        return calendar;
    }

    public static Calendar AddDays(Calendar calendar,int days){
        calendar.add(Calendar.DATE,days);
        return calendar;
    }

    public static Calendar AddHours(Calendar calendar,int hours){
        calendar.add(Calendar.HOUR,hours);
        return calendar;
    }

    public static Calendar AddMinutes(Calendar calendar,int minutes){
        calendar.add(Calendar.MINUTE,minutes);
        return calendar;
    }

    public static Calendar AddSeconds(Calendar calendar,int seconds){
        calendar.add(Calendar.SECOND,seconds);
        return calendar;
    }

    public static Calendar GetCalendar(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return calendar;
    }

    public static Date GetDate(Calendar calendar){
        return calendar.getTime();
    }

    public static String GetString(Calendar calendar,String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);

        return sdf.format(calendar.getTime());
    }

    public static Calendar GetCalendar(String str,String format) throws ParseException {
        SimpleDateFormat sdf= new SimpleDateFormat(format);
        Date date =sdf.parse(str);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return calendar;
    }
}