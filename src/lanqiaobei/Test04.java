package lanqiaobei;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class Test04 {
    public static void main(String[] args) {
//        正常情况下，小蓝每天跑 1 千米。如果某天是周一或者月初（1 日），为了激励自己，
//        小蓝要跑 2 千米。如果同时是周一或月初，小蓝也是跑 2 千米
//        从 2000 年 1 月 1 日周六（含）到 2020 年 10 月 1 日周四（含）。
//        请问这段时间小蓝总共跑步多少千米？8879
//        跑了21年
        int res = 0;
        int zhou = 0, yue = 0;
        int[] year = new int[21];
        int[] month = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int[] runMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30 ,31};
        int[] pingMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30 ,31};
        year[0] = 2000;
        for (int i = 1; i <= 20; i++) {
            year[i] = year[i - 1] + 1;
        }
        int sum = 0;//先按1KM算
        for (int i = 0; i < 20; i++) {
            if (runYear(year[i]))
                sum += 366;
            else
                sum += 365;
        }
        for (int i = 0; i < 9; i++) {
            sum += runMonth[i];
        }
        try {
            for (int i = 0; i < 20; i++) {//先算2000-2019年
                for (int j = 0; j < 12; j++) {//月
                    switch (month[j]) {
                        case 1:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                            for (int k = 1; k <= runMonth[j]; k++) {
                                int flag = 0;//flag为0表示不是月初
                                if (k == 1) {
                                    yue++;
                                    flag = 1;//防止同时星期一且月初的情况导致重复计算
                                }
                                String date = String.format("%d-%d-%d",year[i],month[j],k);
                                String week = dateToWeek(date);
                                if (week == "星期一" && flag == 0)
                                    zhou++;
                            }
                            break;
                        case 2:
                            if (runYear(year[i])) {
                                for (int k = 1; k <= 29; k++) {
                                    int flag = 0;//flag为0表示不是月初
                                    if (k == 1) {
                                        yue++;
                                        flag = 1;//防止同时星期一且月初的情况导致重复计算
                                    }
                                    String date = String.format("%d-%d-%d",year[i],month[j],k);
                                    String week = dateToWeek(date);
                                    if (week == "星期一" && flag == 0)
                                        zhou++;
                                }
                            }else {
                                for (int k = 1; k <= 28; k++) {
                                    int flag = 0;//flag为0表示不是月初
                                    if (k == 1) {
                                        yue++;
                                        flag = 1;//防止同时星期一且月初的情况导致重复计算
                                    }
                                    String date = String.format("%d-%d-%d",year[i],month[j],k);
                                    String week = dateToWeek(date);
                                    if (week == "星期一" && flag == 0)//不是月初
                                        zhou++;
                                }
                            }
                            break;
                        default:
                            break;
                    }
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //2020为闰年
        try {
            for (int j = 0; j < 9; j++) {//月
                switch (month[j]) {
                    case 1:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        for (int k = 1; k <= runMonth[j]; k++) {
                            int flag = 0;//flag为0表示不是月初
                            if (k == 1) {
                                yue ++;
                                flag = 1;//防止同时星期一且月初的情况导致重复计算
                            }
                            String date = String.format("%d-%d-%d", 2020, month[j], k);
                            String week = dateToWeek(date);
                            if (week == "星期一" && flag == 0)
                                zhou ++;
                        }
                        break;
                    case 2:
                            for (int k = 1; k <= 29; k++) {
                                int flag = 0;//flag为0表示不是月初
                                if (k == 1) {
                                    yue++;
                                    flag = 1;//防止同时星期一且月初的情况导致重复计算
                                }
                                String date = String.format("%d-%d-%d", 2020, month[j], k);
                                String week = dateToWeek(date);
                                if (week == "星期一" && flag == 0)
                                    zhou++;
                            }
                        break;
                    default:
                        break;
                }
            }
        }catch (ParseException e) {
            e.printStackTrace();
        }
        res = zhou + sum + yue;
        System.out.println(res + 2);//2020-10-1加2
    }
    public static String dateToWeek(String datetime) throws java.text.ParseException {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
        Calendar cal = Calendar.getInstance(); // 获得一个日历
        Date datet = null;
        datet = (Date) f.parse(datetime);
        cal.setTime(datet);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的某天。
        if (w < 0)
            w = 0;
        return weekDays[w];
    }
//    public static String getWeek(Date date){
//
//        String[] weeks = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(date);
//        int week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;
//        if(week_index<0){
//            week_index = 0;
//        }
//        return weeks[week_index];
//    }
    public static boolean runYear(int year) {
        if(year%4==0&&year%100!=0||year%400==0) {
            return true;
        }
        return false;
    }
}
