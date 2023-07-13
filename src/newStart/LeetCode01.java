package newStart;

import java.math.BigInteger;
import java.util.Arrays;

public class LeetCode01 {
    public static void main(String[] args) {
        System.out.println(new LeetCode01().maxNumOfMarkedIndices(new int[]{9, 2, 5, 4}));
        ;
    }

    public int maxNumOfMarkedIndices(int[] nums) {
        //先进行排序
        Arrays.sort(nums);
        int ans = 0;
        boolean[] flag = new boolean[nums.length];
        int left = nums.length / 2 - 1, right = nums.length / 2;
        for (int i = left; i >= 0; i--) {
            int j = right;
            while (j <= nums.length - 1) {
                if (2 * nums[i] <= nums[j] && !flag[i] && !flag[j]) {
                    ans += 2;
                    flag[i] = true;
                    flag[j] = true;
                    break;
                } else {
                    j++;
                }
            }
        }
        return ans;
    }

    public int[] divisibilityArray(String word, int m) {
        if (word.length() == 0) return new int[0];
        int[] div = new int[word.length()];
        char[] chars = word.toCharArray();
        div[0] = Integer.parseInt(String.valueOf(chars[0])) % m == 0 ? 1 : 0;
        for (int i = 1; i < div.length; i++) {
            BigInteger temp = new BigInteger(word.substring(0, i + 1));
            BigInteger m_ = new BigInteger(String.valueOf(m));
            BigInteger ans = temp.remainder(m_);
            int a = ans.intValue();
            div[i] = a == 0 ? 1 : 0;
        }
        return div;
    }

    public int[] leftRigthDifference(int[] nums) {
        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];
        int[] ans = new int[nums.length];
        //初始化左右数组
        leftSum[0] = 0;
        rightSum[nums.length - 1] = 0;
        for (int i = 1; i < leftSum.length; i++) {
            leftSum[i] = leftSum[i - 1] + nums[i - 1];
        }
        for (int i = rightSum.length - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + nums[i + 1];
        }
        for (int i = 0; i < ans.length; i++) {
            ans[i] = Math.abs(leftSum[i] - rightSum[i]);
        }
        return ans;
    }
}
