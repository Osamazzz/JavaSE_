package LeetCode_.DoublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Obamazzz
 * @version 1.0
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 */
public class exchangeTest {
    public int[] exchange(int[] nums) {
        List<Integer> list1 = new ArrayList<>();//奇数
        List<Integer> list2 = new ArrayList<>();//偶数
        for (int num : nums) {
            if (num % 2 != 0) {
                list1.add(num);
            }
            if (num % 2 == 0) {
                list2.add(num);
            }
        }
        list1.addAll(list2);
        int[] res = new int[list1.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list1.get(i);
        }
        return res;
    }

    //类似快排的思想->双指针
    public int[] exchange2(int[] nums) {
        int i = 0, j = nums.length - 1;//i为奇数指针，j为偶数指针
        while (i < j) {
            while (i < j && (nums[i] & 1) == 1) i++;//& 为按位与
            while (i < j && (nums[j] & 1) == 0) j--;
            swap(nums, i, j);
        }
        return nums;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
