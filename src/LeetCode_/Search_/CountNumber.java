package LeetCode_.Search_;

/**
 * @author Obamazzz
 * @version 1.0
 * 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 */
public class CountNumber {
    public int search(int[] nums, int target) {
        int count = 0;
        int low = 0, high = nums.length - 1;
        int mid = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                count++;
                break;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        //搜索后面的数字
        for (int i = mid + 1; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
            } else {
                break;
            }
        }
        //搜索前面的数字
        for (int i = mid - 1; i >= 0; i--) {
            if (nums[i] == target) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
    // 使用二分法分别找到 左边界 left 和 右边界 right,
    // 易得数字 target 的数量为 right - left - 1.
    // left为刚好比target小的数的下标，right为比target刚好大的下标
    public int search2(int[] nums, int target) {
        // 搜索右边界 right
        int i = 0, j = nums.length - 1;
        //退出循环时i已经大于j
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] <= target) i = m + 1;
            else j = m - 1;
        }
        //i右边界
        int right = i;
        // 若数组中无 target ，则提前返回
        if(j >= 0 && nums[j] != target) return 0;
        // 搜索左边界 right
        i = 0; j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] < target) i = m + 1;
            else j = m - 1;
        }
        int left = j;
        return right - left - 1;
    }

}
