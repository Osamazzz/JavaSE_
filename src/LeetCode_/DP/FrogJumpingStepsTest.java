package LeetCode_.DP;

/**
 * @author Obamazzz
 * @version 1.0
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n级的台阶总共有多少种跳法。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * f(n) = f(n - 1) + f(n - 2)
 */
public class FrogJumpingStepsTest {
    //DP
    public int numWays(int n) {
        if (n <= 1)
            return 1;
        int[] dp = new int[n + 1];
        dp[1] = dp[0] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }
}
