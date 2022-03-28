package LeetCode_.DP;

/**
 * @author Obamazzz
 * @version 1.0
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 * 空间复杂度降低
 * 由于 dp[i]只与 dp[i-1] 和 nums[i]有关系，
 * 因此可以将原数组 nums 用作 dp 列表，即直接在 nums 上修改即可。
 */
public class maxSubArrayTest {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int max = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < dp.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                //如果dp[i - 1]小于0，说明其会对dp[i]产生负影响，故不加入，直接让dp[i]=nums[i]
                dp[i] = nums[i];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}
