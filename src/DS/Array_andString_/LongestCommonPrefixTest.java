package DS.Array_andString_;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class LongestCommonPrefixTest {
    public static void main(String[] args) {
        String[] strs = {"reflower","flow","flight"};
        LongestCommonPrefixTest longestCommonPrefixTest = new LongestCommonPrefixTest();
        String res = longestCommonPrefixTest.longestCommonPrefix(strs);
        System.out.println(res);
    }

    public String longestCommonPrefix(String[] strs) {
        String res = null;
        int maxlengthIndex = 0;
        for (int i = 0; i < strs.length; i++) {
            //找到最长字符串所在的下标
            if (strs[i].length() > strs[maxlengthIndex].length())
                maxlengthIndex = i;
        }
        String s = strs[maxlengthIndex];
        int[] nums = new int[strs.length];//记录字符串前缀长度
        for (int i = 0; i < strs.length; i++) {
            nums[i] = find(s, strs[i]);
        }
        int a = nums[0];//前缀长度
        for (int num : nums) {
            if (num < a)
                a = num;
        }
        res = s.substring(0, a);
        return res;
    }
    public static int find(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        int tLen = t.length();

        int i = 0;
        while (i < tLen) {
            if (ss[i] == tt[i]) {
                i++;
            } else
                break;
        }
        return i;
    }
}
