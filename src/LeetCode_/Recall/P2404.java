package LeetCode_.Recall;

import java.util.Scanner;

/**
 * @author Obamazzz
 * @version 1.0
 * 任何一个大于1的自然数n，总可以拆分成若干个小于n的自然数之和。
 * 现在给你一个自然数n，要求你求出n的拆分成一些数字的和。
 * 每个拆分后的序列中的数字从小到大排序。
 * 然后你需要输出这些序列，其中字典序小的序列需要优先输出。
 */
public class P2404 {
    public static int[] arr;
    public static int n;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        arr = new int[10];
        dfs(0, 0, 1);
    }

    public static void dfs(int sum, int index, int zz) {
        if (sum == n) {
            for (int i = 0; i < index - 1; i++) {//输出除最后一个外所有前面的
                System.out.print(arr[i] + "+");
            }
            System.out.println(arr[index - 1]);//输出最后一个
            return;
        }
        if (sum > n) {//和加过头就直接返回
            return;
        }
        for (int i = zz; i <= n - 1; i++) {//每次从zz开始,搜到n-1
            arr[index] = i;//存储
            dfs(sum + i, index + 1, i);//进行下一次搜索,sum+i,索引+1
//			arr[index] = 0;//回溯:搜索完成后把index的arr值重新设为0,供其余拆分方法使用
            //其实回溯可要可不要,因为每次输出的是前index个值,上一次拆分的index后面的值就算不重置对输出也毫无影响
        }
    }
}
