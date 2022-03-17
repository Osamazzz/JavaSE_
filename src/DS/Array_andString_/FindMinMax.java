package DS.Array_andString_;

import java.util.Arrays;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class FindMinMax {
    public static void main(String[] args) {
        int[] nums = {6, 2, 6, 5, 1, 2};
        FindMinMax findMinMax = new FindMinMax();
        int minMax = findMinMax.arrayPairSum(nums);
        System.out.println(minMax);
    }

    public int arrayPairSum(int[] nums) {
        //先给数组排序
//        for (int i = 1; i < nums.length; i++) {
//            for (int j = 0; j < nums.length - i; j++) {
//                if (nums[j] > nums[j + 1]) {
//                    int temp = nums[j];
//                    nums[j] = nums[j + 1];
//                    nums[j + 1] = temp;
//                }
//            }
//        }
        Arrays.sort(nums);
        int minMax = 0;
        //再让数组中下标为偶数的元素相加
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                minMax += nums[i];
            }
        }
        return minMax;
    }
}
