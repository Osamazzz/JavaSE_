package DS.Array_andString_;

import java.util.Arrays;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class SumOfTwoNumbers {
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        SumOfTwoNumbers sumOfTwoNumbers = new SumOfTwoNumbers();
        int[] res = sumOfTwoNumbers.twoSum(arr, target);
        System.out.println(Arrays.toString(res));

    }

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
            } else if (numbers[front] + numbers[rear] > target){//如果头元素和尾元素之和大于target，尾指针后移
                rear--;
            }
        }
        return res;
    }
}
