package LeetCode_.Recall;

/**
 * @author Obamazzz
 * @version 1.0
 * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */
public class existTest {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, words, i, j, 0))
                    return true;
            }
        }
        //搜索完毕时仍未返回true则说明无匹配的字符单元格
        return false;
    }

    public boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        // 如果数组越界或者字符不匹配，则返回false
        if (i >= board.length || i < 0 || j >= board[0].length ||
                j < 0 || board[i][j] != word[k])
            return false;
        if (k == word.length - 1)
            return true;
        //标记当前元素，防止搜索时重复访问(即一个字符只能对应一个字符)
        board[i][j] = '\0';
        //往四个方向搜索,只要有一个方向成功就行
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1)
                || dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i, j - 1, k + 1);
        //还原字符,回溯
        board[i][j] = word[k];
        return res;
    }
}
