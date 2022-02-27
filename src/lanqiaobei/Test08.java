package lanqiaobei;

import java.util.Arrays;

/**
 * @author Obamazzz
 * @version 1.0
 */
//        小蓝有很多数字卡片，每张卡片上都是数字 0 到 9。
//        小蓝准备用这些卡片来拼一些数，他想从 1 开始拼出正整数，
//        每拼一个， 就保存起来，卡片就不能用来拼其它数了。
//        小蓝想知道自己能从 1 拼到多少。 例如，当小蓝有 30 张卡片，
//        其中 0 到 9 各 3 张，则小蓝可以拼出 1 到 10，
//        但是拼 11 时卡片 1 已经只有一张了，不够拼出 11。
//        现在小蓝手里有 0 到 9 的卡片各 2021 张，共 20210 张，
//        请问小蓝可以从 1 拼到多少？
public class Test08 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Arrays.fill(arr, 2021);
        int res = 1;
        while (true) {
            char[] chars = String.valueOf(res).toCharArray();// 将数字分解出来
            int[] arr1 = new int[chars.length];
            for (int j = 0; j < chars.length; j++) {
                arr1[j] = chars[j] - 48;
            }
            int flag = 1;//还有卡牌剩余
            for (int i : arr1) {
                if (arr[i] > 0) {//如果卡牌还剩余
                    arr[i]--;
                } else {
                    flag = 0;//卡牌没有剩余的了
                    res--;//最后一次res++时会加多一次
                    break;
                }
            }
            if (flag == 1)
                res++;
            else
                break;
        }
        System.out.println(res);
    }
}
