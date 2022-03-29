package LeetCode_.DP;

/**
 * @author Obamazzz
 * @version 1.0
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物
 * 设 f(i, j)f(i,j) 为从棋盘左上角走至单元格 (i ,j)(i,j) 的礼物最大累计价值，
 * 易得到以下递推关系：f(i,j)f(i,j) 等于 f(i,j-1)f(i,j−1) 和 f(i-1,j)f(i−1,j) 中的较大值
 * 加上当前单元格礼物价值 grid(i,j)grid(i,j) 。
 * f(i,j)=max[f(i,j−1),f(i−1,j)]+grid(i,j)
 */
public class MaxGiftPriceTest {
    public static void main(String[] args) {

    }

    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {//起始元素
                    dp[i][j] = grid[i][j];
                } else if (i == 0) {//为矩阵第一行元素，只可从左边到达
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                } else if (j == 0) {//为矩阵第一列元素，只可从上边到达
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                } else {//可从左边或上边到达
                    dp[i][j] = grid[i][j] + Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    //简化空间复杂度
    public int maxValue2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                if (i == 0) grid[i][j] += grid[i][j - 1];
                else if (j == 0) grid[i][j] += grid[i - 1][j];
                else grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[m - 1][n - 1];
    }

    public int maxValue3(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int j = 1; j < n; j++) // 初始化第一行
            grid[0][j] += grid[0][j - 1];
        for (int i = 1; i < m; i++) // 初始化第一列
            grid[i][0] += grid[i - 1][0];
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
        return grid[m - 1][n - 1];
    }
}
