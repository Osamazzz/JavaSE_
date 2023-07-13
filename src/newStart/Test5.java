package newStart;

import java.util.HashMap;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，
 * 并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 */
public class Test5 {
    public static void main(String[] args) {
        int[] arr = {0,1};
        System.out.println(new Test5().missingNumber(arr));
    }

    public int missingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length - 1) {
            if (nums[i + 1] - nums[i] > 1) {
                return nums[i] + 1;
            }
            i++;
        }
        return -1;
    }
    //排序数组中的搜索问题，首先想到 二分法 解决
    public int missingNumber2(int[] nums) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] == m) i = m + 1;
            else j = m - 1;
        }
        return i;
    }


}
