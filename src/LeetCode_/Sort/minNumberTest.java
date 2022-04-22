package LeetCode_.Sort;

import java.util.Arrays;

/**
 * @author Obamazzz
 * @version 1.0
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 若拼接字符串 x + y > y + x，则 x “大于” y ；
 * 反之，若 x + y < y + x ，则 x “小于” y ；
 * 例如一个数组中有3和30,330>303，那么3就“大于”30，意味着3应该排30后面，即303，才能满足题目要求
 * 根据以上规则，套用任何排序方法对 nums 执行排序即可
 */
public class minNumberTest {
    public static void main(String[] args) {
        int a = ("3" + "30").compareTo("30" + "3");
        System.out.println(a);
    }
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        quickSort(strs, 0, strs.length - 1);
        StringBuilder res = new StringBuilder();
        for(String s : strs)
            res.append(s);
        return res.toString();
    }
    void quickSort(String[] strs, int l, int r) {
        if(l >= r) return;
        int i = l, j = r;
        String tmp;
        while(i < j) {
            while((strs[j] + strs[l]).compareTo(strs[l] + strs[j]) >= 0 && i < j) j--;
            while((strs[i] + strs[l]).compareTo(strs[l] + strs[i]) <= 0 && i < j) i++;
            tmp = strs[i];
            strs[i] = strs[j];
            strs[j] = tmp;
        }
        tmp = strs[i];
        strs[i] = strs[l];
        strs[l] = tmp;
        quickSort(strs, l, i - 1);
        quickSort(strs, i + 1, r);
        Arrays.sort(strs);
    }
    public String minNumber2(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder();
        for(String s : strs)
            res.append(s);
        return res.toString();
    }
}
