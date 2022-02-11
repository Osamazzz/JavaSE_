package lanqiaobei;

import java.util.Scanner;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class BubblesortTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        sort.sort(arr);
        for (int i: arr) {
            System.out.print(i + " ");
        }
    }
}

class sort {
    public static void sort(int[] arr) {
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
}
