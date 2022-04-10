package lanqiaobei.Exercise_;

import java.util.*;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class Exercise04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long n = scan.nextLong();//输入值，查找
        long[] arr = new long[44725];
        arr[0] = 1;
        long k = 1L;//k来定义位置
        if (n == 1) {
            System.out.println(1);
            return;
        }
        for (int i = 1; i < 44725; i++) {
            for (int j = i; j >= 1; j--) {
                arr[j] += arr[j - 1];//换行后，用自己进行运算，减少内存
                if (arr[j] == n) {
                    System.out.println(k + i - j + 1);
                    return;//如果找到了就结束
                }
            }
            k += (i + 1);
        }
        System.out.println(((1 + n) * n / 2) + 2);
    }

}
