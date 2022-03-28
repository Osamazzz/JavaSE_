package DS.Array_andString_;

/**
 * @author Obamazzz
 * @version 1.0
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 */

public class BinaryInsertSearch {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 7;
        System.out.println(new Solution03().searchInsert(nums, target));
    }
}

class Solution03 {

    public int searchInsert(int[] nums, int target) {
        // 二分法
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            // 防止 left+right 整型溢出
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            }
        }
        return low;
    }
}