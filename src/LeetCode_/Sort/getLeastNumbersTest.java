package LeetCode_.Sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Obamazzz
 * @version 1.0
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4
 * 题目只要求返回最小的 k 个数，对这 k 个数的顺序并没有要求。因此，只需要将数组划分为 最小的 kk 个数 和 其他数字 两部分即可，而快速排序的哨兵划分可完成此目标。
 * 根据快速排序原理，如果某次哨兵划分后 基准数正好是第 k+1 小的数字 ，那么此时基准数左边的所有数字便是题目所求的 最小的 k 个数 。
 * 根据此思路，考虑在每次哨兵划分后，判断基准数在数组中的索引是否等于 k ，若 true 则直接返回此时数组的前 k 个数字即可。
 */
public class getLeastNumbersTest {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                //如果还有数比minIndex所在数小
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        //arr赋值给res
        if (k >= 0) System.arraycopy(arr, 0, res, 0, k);
        return res;
    }

    public int[] getLeastNumbers2(int[] arr, int k) {
        if (k >= arr.length) return arr;
        return quickSort(arr, k, 0, arr.length - 1);
    }

    private int[] quickSort(int[] arr, int k, int l, int r) {
        int i = l, j = r;
        while (i < j) {
            while (i < j && arr[j] >= arr[l]) j--;
            while (i < j && arr[i] <= arr[l]) i++;
            swap(arr, i, j);
        }
        swap(arr, i, l);
        if (i > k) return quickSort(arr, k, l, i - 1);
        if (i < k) return quickSort(arr, k, i + 1, r);
        return Arrays.copyOf(arr, k);
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //二叉堆
    public int[] getLeastNumbers3(int[] arr, int k) {
        if (arr.length == 0) return null;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Comparator.comparing(Integer -> Integer));
        for (int i : arr) pq.add(i);
        int[] min = new int[k];
        for (int i = 0; i < k; i++) min[i] = pq.poll();
        return min;
    }
}
