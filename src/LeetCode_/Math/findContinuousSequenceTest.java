package LeetCode_.Math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Obamazzz
 * @version 1.0
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 */
public class findContinuousSequenceTest {
    public static void main(String[] args) {
        List<ArrayList<Integer>> list = new ArrayList<>();

        int[][] arr = {{1, 2, 3}, {4, 5}};
        for (int i = 0; i < arr.length; i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < arr[i].length; j++) {
                tmp.add(arr[i][j]);
            }
            list.add(tmp);
        }

        int[][] arr2 = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            arr2[i] = new int[list.get(i).size()];
            for (int j = 0; j < arr[i].length; j++) {
                arr2[i][j] = list.get(i).get(j);
            }
        }

        int[][] res = findContinuousSequence2(98160);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
    // 暴力枚举，超时
    public static int[][] findContinuousSequence(int target) {
        //因为该序列至少含有两个数，所以由中间开始取
        int end = (int) Math.ceil(target / 2.0);
        List<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 1; i < end; i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            int flag = 0;
            for (int j = i + 1; j <= end; j++) {
                if ((i + j) * (j - i + 1) / 2 == target) {
                    for (int k = i; k <= j; k++) {
                        tmp.add(k);
                    }
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                list.add(tmp);
            }
        }
        int[][] res = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            res[i] = new int[list.get(i).size()];
            for (int j = 0; j < res[i].length; j++) {
                res[i][j] = list.get(i).get(j);
            }
        }
        return res;
    }
    // 数学推导
    public static int[][] findContinuousSequence2(int target) {
        int i = 1;
        double j = 2.0;
        List<int[]> list = new ArrayList<>();
        // 确定左边界i和target，可以通过以下公式确定j，若j为整数，则j为可行解之一
//        j = (-1 + Math.sqrt(1 + 4 * (2 * target + (long) i * i - i))) / 2;
        while (i < j) {
            j = (-1 + Math.sqrt(1 + 4 * (2L * target + (long) i * i - i))) / 2;
            if (j == (int) j) {
                int[] tmp = new int[(int) j - i + 1];
                //赋值
                for (int k = i; k <= (int) j; k++) {
                    tmp[k - i] = k;
                }
                list.add(tmp);
            }
            i++;
        }
        return list.toArray(new int[0][]);
    }
    // 双指针
    // 当 s > target时： 向右移动左边界 i = i + 1并更新元素和 s
    //当 s < target时： 向右移动右边界 j = j + 1并更新元素和 s
    //当 s = target时： 记录连续整数序列，并向右移动左边界 i = i + 1
    public int[][] findContinuousSequence3(int target) {
        int i = 1, j = 2, s = 3;
        List<int[]> res = new ArrayList<>();
        while(i < j) {
            if(s == target) {
                int[] ans = new int[j - i + 1];
                for(int k = i; k <= j; k++)
                    ans[k - i] = k;
                res.add(ans);
            }
            if(s >= target) {
                s -= i;
                i++;
            } else {
                j++;
                s += j;
            }
        }
        return res.toArray(new int[0][]);
    }
}
