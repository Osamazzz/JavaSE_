package LeetCode_.Sort;

import java.util.Arrays;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class SortTest {
    public static void main(String[] args) {
        int[] arr = {5, 7, 1, 3, 9, 20, 4, 8};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr2 = {5, 7, 1, 3, 9, 20, 4, 8};
        quickSort(arr2, 0, arr2.length - 1);
        System.out.println(Arrays.toString(arr2));
        int[] arr3 = {5, 7, 1, 3, 9, 20, 4, 8};
        mergeSort(arr3);
        System.out.println(Arrays.toString(arr3));
    }

    //冒泡
    public static void bubbleSort(int[] nums) {
        int N = nums.length;
        for (int i = 1; i < N; i++) {
            boolean flag = false; // 初始化标志位
            for (int j = 0; j < N - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                    flag = true;  // 记录交换元素
                }
            }
            if (!flag) break;     // 内循环未交换任何元素，则跳出
        }
    }

    //选择
    public static void selectSort(int[] nums) {
        int N = nums.length;
        for (int i = 0; i < N - 1; i++) {
            int minIndex = i;
            //从i之后开始寻找最小值所在的索引
            for (int j = i + 1; j < N; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }
            //交换
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
    }

    //插入
    public static void insertSort(int[] nums) {
        int N = nums.length;
        //从第二个开始
        for (int i = 1; i < N; i++) {
            int cur = nums[i];
            //要插入的位置的前一位
            int pre = i - 1;
            while (pre >= 0 && nums[pre] > cur) {
                nums[pre + 1] = nums[pre];
                pre--;
            }
            //找到插入位置
            nums[pre + 1] = cur;
        }
    }

    //快速
    public static void quickSort(int[] nums, int left, int right) {
        //如果子数组长度为一则终止递归
        if (left >= right) return;
        //找基准数应该在的位置的索引
        int index = partition(nums, left, right);
        //递归左右子数组
        quickSort(nums, left, index - 1);
        quickSort(nums, index + 1, right);
    }

    //找基准数应该在的位置
    public static int partition(int[] nums, int left, int right) {
        //一般以left所在的数作为基准数
        int i = left, j = right;
        //该循环结束后基准数左边的数都比它小，右边的都比它大
        while (i < j) {
            //j先动
            while (i < j && nums[j] >= nums[left]) j--;
            while (i < j && nums[i] <= nums[left]) i++;
            //交换数字，将它们放在应该在的位置上
            swap(nums, i, j);
        }
        //将基准数放在应该在的位置上
        swap(nums, left, i);
        return i;//返回基准数所在的索引
    }

    //交换方法
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        sort(arr, 0, arr.length - 1, temp);
    }

    private static void sort(int[] arr, int left, int right, int[] temp) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        sort(arr, left, mid, temp);//左边归并排序，使得左子序列有序
        sort(arr, mid + 1, right, temp);//右边归并排序，使得右子序列有序
        merge(arr, left, mid, right, temp);//将两个有序子数组合并操作
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;//左序列指针
        int j = mid + 1;//右序列指针
        int t = 0;//临时数组指针
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        while (i <= mid) {//将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
        }
        while (j <= right) {//将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }
}
