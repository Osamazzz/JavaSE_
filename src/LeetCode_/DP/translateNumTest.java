package LeetCode_.DP;

/**
 * @author Obamazzz
 * @version 1.0
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，
 * ……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。
 * 请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 */
public class translateNumTest {
    public int translateNum(int num) {
        //可以看做特殊的青蛙跳台阶问题
        String str = String.valueOf(num);
        if (str.length() == 1)
            return 1;
        int[] dp = new int[str.length()];
        // 初始化
        dp[0] = 1;
        // 如果最开始的两个字符在10和25之间
        if (str.charAt(0) == '1' || str.charAt(0) == '2' && str.charAt(1) <= '5')
            dp[1] = 2;
        else dp[1] = 1;
        for (int i = 2; i < str.length(); i++) {
            // 如果第i个字符和第i-1个字符组成的数字j满足以下条件，即j在10和25之间
            if (str.charAt(i - 1) == '1' || str.charAt(i - 1) == '2' && str.charAt(i) <= '5')
                dp[i] = dp[i - 1] + dp[i - 2];
            else dp[i] = dp[i - 1];
        }
        return dp[str.length() - 1];
    }
    public int translateNum2(int num) {
        String s = String.valueOf(num);
        int a = 1, b = 1;
        for (int i = 2; i <= s.length(); i++) {
            String tmp = s.substring(i - 2, i);
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
            b = a;
            a = c;
        }
        return a;
    }
}
