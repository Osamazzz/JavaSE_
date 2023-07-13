package newStart;

import jdk.internal.org.objectweb.asm.Handle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test6 {
    public static void main(String[] args) {
        String s = "abaccdeff";
        System.out.println(new Test6().firstUniqChar(s));
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length;//行
        int n = matrix[0].length;//列
        //类似二叉搜索树，从矩阵右上角开始查找
        int i = 0;//行索引
        int j = n - 1;//列索引
        while (i < m && j < n) {
            if (i < 0 || j < 0) break;
            if (target == matrix[i][j]) {
                return true;
            } else if (target > matrix[i][j]) {//往下一行找
                i++;
            } else {//往上一列找
                j--;
            }
        }
        return false;
    }

    public int minArray(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[0];
    }

    public char firstUniqChar(String s) {
        if (s.length() == 0) return ' ';
        HashMap<Character, Integer> map = new HashMap<>();
        //先对String中的字符进行计数
        for (int i = 0; i < s.length(); i++) {
            //若map中没有该字符
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                int count = map.get(s.charAt(i));
                map.put(s.charAt(i), count + 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            //获取字符个数
            int count = map.get(s.charAt(i));
            if (count == 1) return s.charAt(i);
        }
        return ' ';
    }

}
