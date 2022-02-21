package Common_Class.Arrays_;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class ArraysTest02 {
    public static void main(String[] args) {
        //模拟排序
        int[] arr = {1,5,33,1000,-1,0};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Integer i1 = (Integer) o1;//前
                Integer i2 = (Integer) o2;//后
                //后减前大于零(后面大)就换位置->降序排序
                //前减后大于零(前面大)就换位置->升序排序
                return i2 - i1;
            }
        });
        System.out.println(Arrays.toString(arr));
    }
    //使用冒泡排序
    public static void bubbleSort(int[] arr) {
        int temp = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

            }
        }
    }
    //定制冒泡排序
    public static void bubbleSort(int[] arr, Comparator comparator) {
        int temp = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                //数组排序方式由下面这个方法返回的值来决定
                if (comparator.compare(arr[j], arr[j + 1]) > 0) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
