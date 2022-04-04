package LeetCode_.Recall;

import DS.BinaryTree_.TreeNode;

/**
 * @author Obamazzz
 * @version 1.0
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。
 * 如果一棵二叉树和它的镜像一样，那么它是对称的。
 */
public class isSymmetricTest {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return compare(root.left, root.right);
    }

    public boolean compare(TreeNode left, TreeNode right) {
        // 如果为空则返回true
        if (left == null && right == null)
            return true;
        boolean res = false;
        // 若左右子树不为空，且左右子树根节点的值相等，则返回true
        if ((left != null && right != null) && (left.val == right.val)
                && compare(left.left, right.right) && compare(left.right, right.left))
            res = true;
        // 否则返回false
        return res;
    }
    public boolean isSymmetric2(TreeNode root) {
        return root == null || recur(root.left, root.right);
    }
    boolean recur(TreeNode L, TreeNode R) {
        if(L == null && R == null) return true;
        if(L == null || R == null || L.val != R.val) return false;
        return recur(L.left, R.right) && recur(L.right, R.left);
    }
}
