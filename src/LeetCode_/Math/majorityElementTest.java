package LeetCode_.Math;

import java.util.Arrays;

/**
 * @author Obamazzz
 * @version 1.0
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 */
public class majorityElementTest {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];//排序后位于中间的数一定为众数
    }
    public int majorityElement2(int[] nums) {
        int x = 0, votes = 0;
        for(int num : nums){
            if(votes == 0)//当发生 票数和 = 0时，剩余数组的众数一定不变
                x = num;// 当 票数 votes 等于 0 ，则假设当前数字 num 是众数；
            votes += num == x ? 1 : -1;//当 num = x 时，票数 votes 自增 1 ；当 num != x 时，票数 votes 自减 1
        }
        return x;//最后一轮假设的数字即为众数
    }
}
