package LeetCode_.Recall;

/**
 * @author Obamazzz
 * @version 1.0
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 */
public class lowestAncestorTest {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // root为空或者找到pq节点
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 如果左子树为空，就往右子树找
        if (left == null)
            return right;
        // 同理，如果右子树为空，就往左子树找
        if (right == null)
            return left;
        // 都不为空，说明pq在异侧，直接返回root
        return root;
    }

}
