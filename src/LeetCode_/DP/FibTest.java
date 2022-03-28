package LeetCode_.DP;

/**
 * @author Obamazzz
 * @version 1.0
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1
 */
public class FibTest {
    public static void main(String[] args) {
        int[] dp = new int[3];
        dp[1] = 1;
        System.out.println(dp[2]);
    }
    public int fib(int n) {
        int a = 1000000007;
        if (n == 0)
            return 0;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2])%a;
        }
        return dp[n];
    }
}
