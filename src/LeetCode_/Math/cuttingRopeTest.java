package LeetCode_.Math;

import java.util.Arrays;
import java.util.Map;

/**
 * @author Obamazzz
 * @version 1.0
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
public class cuttingRopeTest {
    //数学推导，尽可能分成多个3，最后剩1则把3+1换成2+2，剩2则保留
    public int cuttingRope(int n) {
        if(n <= 3) return n - 1;
        int a = n / 3, b = n % 3;
        if(b == 0) return (int)Math.pow(3, a);
        if(b == 1) return (int)Math.pow(3, a - 1) * 4;
        return (int)Math.pow(3, a) * 2;
    }
    //动态规划
    public int cuttingRope2(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(dp[i - j] * j, (i - j)*j));
            }
        }
        return dp[n];
    }
}
