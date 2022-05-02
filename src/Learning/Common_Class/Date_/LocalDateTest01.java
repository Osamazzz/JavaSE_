package Learning.Common_Class.Date_;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class LocalDateTest01 {
    public static void main(String[] args) {
        //第三代日期类
        LocalDateTime ldt = LocalDateTime.now();//当前日期
        System.out.println(ldt);
        System.out.println(ldt.getYear());//year
        System.out.println(ldt.getMonth());//英语的月份表示
        System.out.println(ldt.getMonthValue());//数字的月份表示

        System.out.println();

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);//日期
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);//时间
        //可以使用DatetimeFormat类来格式化
        //用法和之前的SimpleDateFormat类似
        String formatStr = "yyyy年MM月dd日 HH小时mm分钟ss秒 E";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(formatStr);
        String formatStr2 = dtf.format(ldt);
        System.out.println("格式化后的日期:"+formatStr2);
        System.out.println();
        //时间戳Instant,类似于Date类
        Instant instant = Instant.now();
        System.out.println(instant);
        //instant->date
        Date date = Date.from(instant);
        System.out.println(date);
        //date->instant
        System.out.println(date.toInstant());
    }
}
