package LeetCode_.DP;

import java.util.*;

/**
 * @author Obamazzz
 * @version 1.0
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 */
public class lengthOfLongestSubstringTest {
    //dp[j]代表以字符 s[j]s[j] 为结尾的 “最长不重复子字符串” 的长度
    //固定右边界 j ，设字符 s[j] 左边距离最近的相同字符为 s[i] ，
    // 即 s[i] = s[j]
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int res = 1, len = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int[] dp = new int[len];
        //初始化
        dp[0] = 1;
        //把第一个字符放入map中
        map.put(s.charAt(0), 0);
        for (int i = 1; i < len; i++) {
            //获取索引,默认索引为右边界-1则不存在
            int index = map.getOrDefault(s.charAt(i), -1);
            map.put(s.charAt(i), i);//更新哈希表
            dp[i] = i - index > dp[i - 1] ? dp[i - 1] + 1 : i - index;
            res = Math.max(res, dp[i]);//更新结果

        }
        return res;
    }

    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0, len = s.length();
        for (int j = 0; j < len; j++) {
            int i = dic.getOrDefault(s.charAt(j), -1); // 获取索引 i
            dic.put(s.charAt(j), j); // 更新哈希表
            tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
            res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
        }
        return res;
    }
    public int maximumSwap(int num) {
        String str = String.valueOf(num);
        char[] chs = str.toCharArray();
        int[] arr = new int[chs.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = chs[i] - '0';
        }
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < chs.length; ++i) {
            if (max < arr[i]) {
                max = arr[i];
                maxIndex = i;
            }
        }
        int tmp = arr[maxIndex];
        arr[maxIndex] = arr[0];
        arr[0] = tmp;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        String s = sb.toString();
        return Integer.parseInt(s);
    }
}
