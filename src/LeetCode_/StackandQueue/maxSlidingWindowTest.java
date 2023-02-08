package LeetCode_.StackandQueue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Obamazzz
 * @version 1.0
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * 若 i > 0且 队首元素 deque[0]== 被删除元素 nums[i - 1] ：则队首元素出队；
 * 删除 deque内所有 < nums[j]的元素，以保持 deque 递减；
 * 将 nums[j]添加至 deque 尾部；
 * 若已形成窗口（即 i \geq 0i≥0 ）：将窗口最大值（即队首元素 deque[0]）添加至列表 res ；
 */
public class maxSlidingWindowTest {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 3};
        int k = 3;
        int[] res ;
        res = new maxSlidingWindowTest().maxSlidingWindow(arr, 2);
        for (int re : res) {
            System.out.println(re);
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        if (nums.length == 1) return new int[]{nums[0]};
        int[] arrK;
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            arrK = Arrays.copyOfRange(nums, i, i + k);
            res[i] = findMax(arrK);
        }
        return res;
    }

    public int findMax(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for(int j = 0, i = 1 - k; j < nums.length; i++, j++) {
            // 删除 deque 中对应的 nums[i-1]
            if(i > 0 && deque.peekFirst() == nums[i - 1])
                deque.removeFirst();
            // 保持 deque 递减
            while(!deque.isEmpty() && deque.peekLast() < nums[j])
                deque.removeLast();
            deque.addLast(nums[j]);
            // 记录窗口最大值
            if(i >= 0)
                res[i] = deque.peekFirst();
        }
        return res;
    }

}
