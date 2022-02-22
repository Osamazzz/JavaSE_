package Common_Class.Date_;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class DateTest01 {
    public static void main(String[] args) throws ParseException {
        //这里的Date类指的是util包下的，不是sql包下的
        Date d1 = new Date();//获取当前系统时间
        System.out.println(d1);//国外方式表示
        // 这里的格式使用的字母已经规定好，不能随便使用
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss E");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss a E");
        String formatDate = sdf.format(d1);
        System.out.println(formatDate);
        System.out.println(sdf2.format(d1));

        //通过指定毫秒获得时间
        Date d2 = new Date(921245454);
        System.out.println(d2);
        //还可以把一个格式化的字符串转成相应Date
        //得到的date在输出时仍然是国外的格式，如果希望指定格式输出，用SimpleDateFormat对象的format即可
        //在把String转成Date时，使用的sdf格式需要和给的字符串格式一样，否则会抛出转换异常
        String s = "1996年1月1日 10:20:30 星期一";
        Date parseDate = sdf.parse(s);
        System.out.println(parseDate);
        System.out.println(sdf.format(parseDate));
    }
}
