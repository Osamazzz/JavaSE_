package LeetCode_.Motivation;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class spiralOrderTest {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[]{};
        int top = 0;//上边界
        int left = 0;//左边界
        int right = matrix[0].length - 1;//右边界
        int bottom = matrix.length - 1;//下边界
        int k = 0;//res数组的指针
        int[] res = new int[(right + 1) * (bottom + 1)];
        while (true) {
            //左到右
            for (int i = left; i <= right; i++) {
                res[k++] = matrix[top][i];
            }
            //上界大于下界说明打印完成
            //上到下
            if (++top > bottom) break;
            for (int i = top; i <= bottom; i++) {
                res[k++] = matrix[i][right];
            }
            if (--right < left) break;
            //右到左
            for (int i = right; i >= left; i--) {
                res[k++] = matrix[bottom][i];
            }
            if (--bottom < top) break;
            //下到上
            for (int i = bottom; i >= top; i--) {
                res[k++] = matrix[i][left];
            }
            if (++left > right) break;
        }
        return res;
    }
}
