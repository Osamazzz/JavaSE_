package lanqiaobei.Exercise_;

import java.util.Arrays;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class Exercise02 {
    public static void main(String[] args) {
        //使用一个数组A来表示一个大整数a，A[0]表示a的个位，A[1]表示a的十位，依次类推
        int[] arr = new int[1000];
        int num = 10;
        int count = 0;
        Factorial(num, arr);
        for (int i = arr.length - 1; i >= 0; i--) {//从高位开始扫描
            if (arr[i] != 0)
                break;
            count++;
        }
        int length = arr.length - count;
        int[] arr2 = new int[length];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = arr[i];
        }
        for (int i = arr2.length - 1; i >= 0; i--) {
            System.out.print(arr2[i]);
        }
    }

    public static void Factorial(int n, int[] arr) {
        int i = 1;//乘数
        arr[0] = 1;
        if (n == 0)//0!=1
            return;//退出
        while (i <= n) {
            for (int j = 0; j < arr.length; j++) {//先让每个数组中的数乘以i
                arr[j] *= i;
            }
            for (int j = 0; j < arr.length - 1; j++) {//防止数组下标越界
                if (arr[j] > 10) {
                    int temp = arr[j] % 10;//取出个位数
                    arr[j + 1] += (arr[j] - temp) / 10;//除以10再相加
                    arr[j] = temp;
                }
            }
            i++;
        }
    }
}
