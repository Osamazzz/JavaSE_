package lanqiaobei.Exercise_;

import java.util.*;

/**
 * @author Obamazzz
 * @version 1.0
 * 输入一行包含一个单词，单词只由小写英文字母组成。
 * 输出两行，第一行包含一个英文字母，表示单词中出现得最多的字母是哪个。
 * 如果有多个字母出现的次数相等，输出字典序最小的那个。
 * 第二行包含一个整数，表示出现得最多的那个字母在单词中出现的次数。
 */
public class FindWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[] chars = scan.nextLine().toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char aChar : chars) {
            map.put(aChar, 0);
        }
        //再次遍历
        for (char aChar : chars) {
            int value = map.get(aChar);
            map.put(aChar, value + 1);
        }
        Set<Character> keySet = map.keySet();
        int max = 0;
        for (Character ch : keySet) {
            max = Math.max(max, map.get(ch));
        }
        char[] res = new char[26];
        Arrays.fill(res, 'z');
        int j = 0;
        for (Character ch : keySet) {
            if (map.get(ch) == max) {
                res[j] = ch;
                j++;
            }
        }
        char ans = res[0];
        for (char c : res) {
            ans = ans > c ? c : ans;
        }
        System.out.println(ans);
        System.out.println(max);
        scan.close();
    }
}
