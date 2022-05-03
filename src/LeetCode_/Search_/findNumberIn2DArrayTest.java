package LeetCode_.Search_;

/**
 * @author Obamazzz
 * @version 1.0
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class findNumberIn2DArrayTest {
    //以 matrix 中的 左下角元素 为标志数 flag
    //若 flag > target ，则 target 一定在 flag 所在 行的上方 ->flag为所在行最小数，该行最小数都比target大，则flag所在行可被消去
    // 若 flag < target ，则 target 一定在 flag 所在 列的右方 ->flag为所在列最大数，最大数都比target小，则 flag 所在列可被消去。
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        //flag初始化
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > target) i--;
            else if (matrix[i][j] < target) j++;
            else return true;
        }
        //循环退出仍未返回true，则直接返回false
        return false;
    }

}
