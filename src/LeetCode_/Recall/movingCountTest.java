package LeetCode_.Recall;

/**
 * @author Obamazzz
 * @version 1.0
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
 * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 * 设x的各位数之和为s(x)，x+1位s(x+1)，那么当(x+1)%10=0时s(x+1)=s(x)-8
 * (x+1)%10！=0时s(x+1)-s(x)=1
 */
public class movingCountTest {
    public static void main(String[] args) {
        int a = 26;
        a = sums(a);
        System.out.println(a);
    }

    int m, n, k;
    boolean[][] visited;//true表示已经访问过
    public int movingCount(int m, int n, int k) {
        //初始化
        this.k = k;
        this.m = m;
        this.n = n;
        this.visited = new boolean[m][n];
        return dfs(0, 0, 0, 0);
    }

    public int dfs(int i, int j, int si, int sj) {
        //如果数组越界或者已经访问过或者数位和大于k
        if (i >= m || j >= n || visited[i][j] || si + sj > k) return 0;
        visited[i][j] = true;
        //向右搜索
        int right = dfs(i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj);
        //向下搜索
        int down = dfs(i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8);
        return 1 + right + down;
    }

    // 计算数字各个位的和
    public static int sums(int x) {
        int s = 0;
        while (x != 0) {
            s += x % 10;
            x = x / 10;
        }
        return s;
    }
}
