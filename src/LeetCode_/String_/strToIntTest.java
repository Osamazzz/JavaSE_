package LeetCode_.String_;

/**
 * @author Obamazzz
 * @version 1.0
 * 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
 */
public class strToIntTest {
    public int strToInt(String str) {
        char[] chars = str.trim().toCharArray();
        if (chars.length == 0) return 0;
        int i = 1, flag = 1;
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        if (chars[0] == '-') {
            flag = -1;
        } else if (chars[0] != '+') {
            i = 0;
        }
        for (int j = i; j < chars.length; j++) {
            if (chars[j] < '0' || chars[j] > '9') {
                break;
            }
            if (res > bndry || res == bndry && chars[j] > '7') {
                return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (chars[j] - '0');
        }
        return flag * res;
    }
}