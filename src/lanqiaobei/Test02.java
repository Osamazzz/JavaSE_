package lanqiaobei;

/**
 * @author Obamazzz
 * @version 1.0
 */

public class Test02 {
    public static void main(String[] args) {
        //暴力解法
        int count = 0;
        for (int i = 1; i <= 2020; i++) {//分子
            for (int j = 1; j <= 2020; j++) {//分母
                int temp = gcd(i, j);
                if (temp == 1)
                    count++;
            }
        }
        System.out.println(count);
    }
    public static int gcd(int num1, int num2) {//求公约数
        int temp = num1 % num2;//余数
        while (temp != 0) {
            num1 = num2;
            num2 = temp;
            temp = num1 % num2;
        }
        return num2;
    }
}
