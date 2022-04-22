package LeetCode_.Recall;

/**
 * @author Obamazzz
 * @version 1.0
 * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
 */
public class kthLargestTest {
    public int k;
    public int[] res;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        res = new int[k];
        inOrderTravel(root);
        return res[0];
    }

    //倒叙遍历二叉搜索树->左根右
    public void inOrderTravel(TreeNode root) {
        if (k == 0) return;
        if (root == null) return;
        inOrderTravel(root.right);
        if (k != 0)
            visited(root);
        inOrderTravel(root.left);
    }

    public void visited(TreeNode root) {
        res[k - 1] = root.val;
        k--;
    }
}
//
//    int res, k;
//    public int kthLargest(TreeNode root, int k) {
//        this.k = k;
//        dfs(root);
//        return res;
//    }
//    void dfs(TreeNode root) {
//        if(root == null) return;
//        dfs(root.right);
//        if(k == 0) return;
//        if(--k == 0) res = root.val;
//        dfs(root.left);
//    }
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}