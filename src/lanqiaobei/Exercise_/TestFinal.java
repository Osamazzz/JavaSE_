package lanqiaobei.Exercise_;

import java.util.Calendar;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class TestFinal {
    public static void main(String[] args) {
        System.out.println(gcd(10, 8));
        System.out.println(lcm(10, 8));
//        int count = 0;
//        for (int i = 1; i <= 2020 ; i++) {
//            for (int j = 1; j <= 2020; j++) {
//                if (gcd(i, j) == 1) count++;
//            }
//        }
//        System.out.println(count);
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.get(Calendar.YEAR));
        calendar.set(Calendar.YEAR, 2021);
        System.out.println(calendar.get(Calendar.YEAR));
    }
    //最大公约数
    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
