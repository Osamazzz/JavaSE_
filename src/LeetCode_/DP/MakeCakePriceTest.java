package LeetCode_.DP;

/**
 * @author Obamazzz
 * @version 1.0
 * 小力开了一家蛋糕店，并针对不同重量的蛋糕设定了不同售价，分别为：
 * 蛋糕重量	0	1	2	3	4	5	6
 * 售价	    0	2	3	6	7	11	15
 * 问题： 现给定一个重量为 n 的蛋糕，问小力应该如何切分蛋糕，达到最高的蛋糕总售价。
 * f(n)=max(f(i)+p(n−i)),0≤i<n,p(n)为重量为n的蛋糕的售价,即priceList,f(n)为切分后最高的总售价
 */
public class MakeCakePriceTest {
    public static void main(String[] args) {
        MakeCakePriceTest test = new MakeCakePriceTest();
        int[] priceList = {0, 2, 3, 6, 7, 11, 15};
        int res = test.maxCakePrice01(4, priceList);
        System.out.println(res);
    }
    //暴力递归
    int maxCakePrice01(int n, int[] priceList) {
        if (n <= 1)
            return priceList[n];
        int f_n = 0;
        for (int i = 0; i < n; i++) {//从n种组合中选择最高的售价
            f_n = Math.max(f_n, maxCakePrice01(i, priceList) + priceList[n - i]);
        }
        return f_n;
    }

    //记忆化递归
    int maxCakePrice02(int n, int[] priceList, int[] dp) {
        if (n <= 1)
            return priceList[n];
        int f_n = 0;
        for (int i = 0; i < n; i++) {
            int f_i = dp[i] != 0 ? dp[i] : maxCakePrice02(i, priceList, dp);
            f_n = Math.max(f_n, f_i + priceList[n - i]);
        }
        dp[n] = f_n; //记录f_n至dp表
        return f_n;
    }
    int maxCakePrice02Memorized(int n, int[] priceList) {
        int[] dp = new int[n + 1];
        return maxCakePrice02(n, priceList, dp);
    }
    //动态规划
    // f(n)=max(f(i)+p(n−i)),0≤i<n
    int maxCakePrice03(int n, int[] priceList) {
        if (n <= 1)
            return priceList[n];
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {//计算f(1),...,f(n)
            for (int j = 0; j < i; j++) {// 从i种组合中选择最高的作为f(i)
                dp[i] = Math.max(dp[i], dp[j] + priceList[i - j]);
            }
        }
        return dp[n];
    }
}
