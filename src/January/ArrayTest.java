package January;

import java.util.Scanner;

public class ArrayTest {
    public static void main(String[] args) {
        //定义数组
        int[] arr = {10, 2, 35, 7, 589, 1};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.BubbleSort(arr);
        for (int i: arr) {
            System.out.print(i + " ");
        }
    }
}

class BubbleSort {
    public void BubbleSort(int[] arrSort){
        int temp = 0;
        for (int i = 1; i < arrSort.length; i++) {
            for (int j = 0; j < arrSort.length - i; j++) {
                //前面的数据比后面的大则交换
                if (arrSort[j] > arrSort[j + 1]) {
                    temp = arrSort[j];
                    arrSort[j] = arrSort[j + 1];
                    arrSort[j + 1] = temp;
                }
            }
        }
        return ;
    }
}
