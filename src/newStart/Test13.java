package newStart;

import java.util.ArrayList;

public class Test13 {
    public static void main(String[] args) {
        System.out.println(1 ^ 1);
    }

    public int lastRemaining(int n, int m) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(i);
        }
        int index = 0;
        while (arr.size() != 1) {
            index = (index + m - 1) <= arr.size() - 1 ? (index + m - 1) : index + m - 1 - arr.size();
            arr.remove(index);
            index = index > arr.size() - 1 ? 0 : index;
        }
        return arr.get(0);
    }

    public boolean verifyPostorder(int[] postorder) {
        return dfs(postorder, 0, postorder.length - 1);
    }

    public boolean dfs(int[] postorder, int left, int right) {
        //如果子树节点个数小于等于1
        if (left >= right) return true;
        int cur = left;
        //划分左子树
        while (postorder[cur] < postorder[right]) cur++;
        int mid = cur;
        //划分右子树
        while (postorder[cur] > postorder[right]) cur++;
        return cur == right && dfs(postorder, left, mid - 1) && dfs(postorder, mid, right - 1);
    }

    public int uniquePaths(int m, int n) {
        //dp[i][j]表示从[0][0]到[i][j]有多少种走法
        int[][] dp = new int[m][n];
        //初始化dp数组
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) return 0;
        int[][] dp = new int[m][n];
        //初始化dp数组
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) break;
            dp[i][0] = 1;
        }
        for (int i = 0; i < n && obstacleGrid[0][i] == 0; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //如果有障碍物
                if (obstacleGrid[i][j] == 1) continue;
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
