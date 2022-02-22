package Common_Class.Date_;

import java.util.Calendar;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class CalenderTest01 {
    public static void main(String[] args) {
        //Calendar类是一个抽象类，并且构造器是私有化的
        //可以通过getInstance来获取实例
        //该类没有提供格式化的类
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        //获取日历对象的某个日历字段
        System.out.println("年：" + calendar.get(Calendar.YEAR));
        System.out.println("月：" + (calendar.get(Calendar.MONTH) + 1));//月要加1，默认0开始算

    }

}
