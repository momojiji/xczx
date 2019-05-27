package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Auther: wyan
 * @Date: 2018/12/29 10:08
 * @Description:
 */
public class DateUtil {

    /**
     * 功能描述:接受日期参数转换字符串后返回
     * @param: [date]
     * @return: java.lang.String
     * @auther: wyan
     * @date: 2018/12/29 10:09
     */
    public static String formatDateToStr(Date date){

        try {
            //获取当前对象的日期属性 格式化后返回
            //将当前的日期属性格式化后
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //返回处理后的字符串
            return sdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static Date parseStrToDate(String dateStr) {
        //接受日期字符串转换日期后返回
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        return date;
    }

    public static String getCurrentFromatDate() {
        //接受日期字符串转换日期后返回
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date=null;
        try {
            date= sdf.format(new Date());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return date;
    }

    public static Date parseStrToDateToDay(String dateStr) {
        //接受日期字符串转换日期后返回
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        return date;
    }

    //接受字符串后，转成日期，并获取这个月份的天数
    public static Integer parseStrToDateGetDayCount(String dateStr) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
}
