package DS.Array_andString_;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Obamazzz
 * @version 1.0
 * 给你一个下标从 1开始的整数数组numbers,该数组已按 非递减顺序排列，
 * 请你从数组中找出满足相加之和等于目标数target 的两个数。
 * 如果设这两个数分别是 numbers[index1]和 numbers[index2] ，则 1<=index1<index2 <=numbers.length 。
 * 以长度为 2的整数数组[index1,index2]的形式返回这两个整数的下标 index1 和 index2。
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 * 你所设计的解决方案必须只使用常量级的额外空间。
 */


public class SumOfTwoNumbers {
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        SumOfTwoNumbers sumOfTwoNumbers = new SumOfTwoNumbers();
        int[] res = sumOfTwoNumbers.twoSum3(arr, target);
        System.out.println(Arrays.toString(res));

    }

    //滑动指针法
    public int[] twoSum(int[] numbers, int target) {
        int front = 0;
        int rear = numbers.length - 1;
        int[] res = new int[2];
        while (front < rear) {
            if (numbers[front] + numbers[rear] == target) {
                res[0] = front + 1;
                res[1] = rear + 1;
                break;//找到目标值后退出循环
            } else if (numbers[front] + numbers[rear] < target) {//如果头元素和尾元素之和小于target，头指针前移
                front++;
            } else if (numbers[front] + numbers[rear] > target) {//如果头元素和尾元素之和大于target，尾指针后移
                rear--;
            }
        }
        return res;
    }

    //二分法
    public int[] twoSum2(int[] numbers, int target) {
        int j = numbers.length - 1;
        for (int i = 0; i < numbers.length; i++) {
            int low = i + 1;
            while (low <= j) {
                int middle = (low + j) >> 1;
                if (numbers[middle] < target - numbers[i]) {
                    //目标值大于中间值
                    low = middle + 1;
                } else if (numbers[middle] > target - numbers[i]) {
                    //目标值小于中间值
                    j = middle - 1;
                } else {
                    //找到值
                    return new int[]{i + 1, middle + 1};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public int[] twoSum3(int[] nums, int target) {
        //hash法
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]) + 1, i + 1};
            } else {
                //不存在，放入map
                map.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};


    }
}
