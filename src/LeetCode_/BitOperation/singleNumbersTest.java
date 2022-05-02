package LeetCode_.BitOperation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Obamazzz
 * @version 1.0
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 */
public class singleNumbersTest {
    public int[] singleNumbers(int[] nums) {
        int x = 0, y = 0, n = 0, m = 1;
        for(int num : nums)               // 1. 遍历异或
            n ^= num;
        while((n & m) == 0)               // 2. 循环左移，计算 m
            m <<= 1;
        for(int num: nums) {              // 3. 遍历 nums 分组
            if((num & m) != 0) x ^= num;  // 4. 当 num & m != 0
            else y ^= num;                // 4. 当 num & m == 0
        }
        return new int[] {x, y};          // 5. 返回出现一次的数字
    }

    // 在一个数组 nums 中除一个数字只出现一次之外，
    // 其他数字都出现了三次。请找出那个只出现一次的数字。
    public int singleNumber(int[] nums) {
        int res = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, 0);
        }
        for (int i = 0; i < nums.length; i++) {
            int val = map.get(nums[i]);
            map.put(nums[i], val + 1);
        }
        Set<Integer> set = map.keySet();
        for (Integer i : set) {
            if (map.get(i).equals(1)) {
                res = i;
                break;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {9,1,7,9,7,9,7};
        System.out.println(new singleNumbersTest().singleNumber(arr));
    }
}
