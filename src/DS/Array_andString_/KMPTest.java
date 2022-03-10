package DS.Array_andString_;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class KMPTest {
    static int ViolentMatch(String s, String p) {
        //暴力匹配算法
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        int sLen = ss.length;
        int pLen = pp.length;

        int i = 0;
        int j = 0;
        while (i < sLen && j < pLen) {
            if (ss[i] == pp[j]) {
                //①如果当前字符匹配成功（即S[i] == P[j]），则i++，j++
                i++;
                j++;
            } else {
                //②如果失配（即S[i]! = P[j]），令i = i - (j - 1)，j = 0
                i = i - j + 1;
                j = 0;
            }
        }
        //匹配成功，返回模式串p在文本串s中的位置，否则返回-1
        if (j == pLen)
            return i - j;
        else
            return -1;
    }

    /**
     * @param s 目标串
     * @param t 模式串
     * @return s匹配到t的起始下标
     */
    static int KMP(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        int[] next = getNext(tt);
        int i = 0, j = 0;
        int slen = ss.length, tlen = tt.length;
        while (i < slen && j < tlen) {
            if (j == -1 || ss[i] == tt[j]) {
                i++;
                j++;
            } else j = next[j];
        }
        if (j == tlen) return i - j;  //匹配成功返回下标
        return -1;
    }

    /**
     * @param tt 模式串
     * @return 获取t的next数组, next[i]代表t中下标i之前的字符串的最大公共前后缀的长度
     */
    static int[] getNext(char[] tt) {
        int j = 0, k = -1;
        int len = tt.length;
        int[] next = new int[len];
        next[j] = k;
        while (j < len - 1) {
            if (k == -1 || tt[j] == tt[k]) {
                next[++j] = ++k;
            } else k = next[k];
        }
        return next;
    }
}
