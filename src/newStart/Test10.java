package newStart;

import java.util.HashMap;

public class Test10 {
    public static void main(String[] args) {
        System.out.println(new Test10().lengthOfLongestSubstring("aab"));
    }

    public int translateNum(int num) {
        String str = String.valueOf(num);
        int a = 1, b = 1;
        for (int i = 2; i < str.length(); i++) {
            String tmp = str.substring(i - 2, i);
            int temp = tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0 ? a + b : a;
            b = a;
            a = temp;
        }
        return a;
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int[] dp = new int[s.length()];
        dp[0] = 0;
        //初始化map
        map.put(s.charAt(0), 0);
        for (int i = 1; i < s.length(); i++) {
            //取出字符最后一次出现的位置
            int index = map.getOrDefault(s.charAt(i), -1);
            dp[i] = dp[i - 1] < i - index ? dp[i - 1] + 1 : i - index;
            //更新各个字符最后一次出现的位置
            map.put(s.charAt(i), i);
        }
        //遍历dp数组得到最大值
        int res = 0;
        for (int j : dp) {
            if (j > res) {
                //更新res
                res = j;
            }
        }
        return res;
    }

    public int movingCount(int m, int n, int k) {
        //访问数组
        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, 0, 0, m, n, k, visited);
    }

    public int dfs(int i, int j, int s_i, int s_j, int m, int n, int k, boolean[][] visited) {
        if (i >= m || j >= n || k < s_i + s_j || visited[i][j]) return 0;
        visited[i][j] = true;
        int right = dfs(i + 1, j, (i + 1) % 10 != 0 ? s_i + 1 : s_i - 8, s_j, m, n, k, visited);
        int left = dfs(i, j + 1, s_i, (j + 1) % 10 != 0 ? s_j + 1 : s_j - 8, m, n, k, visited);
        return 1 + right + left;
    }

}


class Solution {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //如果找到可行解
                if (dfs(board, words, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    //i,j分别为board行、列索引，k为word的索引
    public boolean dfs(char[][] board, char[] words, int i, int j, int k) {
        //进行可行性剪枝
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != words[k]) return false;
        //匹配完成
        if (k == words.length - 1) return true;
        board[i][j] = '\0';
        //进行搜索
        boolean res = dfs(board, words, i + 1, j, k + 1) || dfs(board, words, i - 1, j, k + 1) ||
                dfs(board, words, i, j + 1, k + 1) || dfs(board, words, i, j - 1, k + 1);
        //恢复数组
        board[i][j] = words[k];
        return res;
    }
}