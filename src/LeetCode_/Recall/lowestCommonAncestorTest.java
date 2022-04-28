package LeetCode_.Recall;

/**
 * @author Obamazzz
 * @version 1.0
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 只可能三种情况：
 * pq在root子树中，且在异侧
 * p = root，q在其左右子树中
 * q = root，p在其左右子树中
 */
public class lowestCommonAncestorTest {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
//             如果pq的值都大于root，往右子树找
            if (root.val < p.val && root.val < q.val)
                root = root.right;
//                 如果pq的值都小于root，往左子树找
            else if (root.val > p.val && root.val > q.val)
                root = root.left;
//            否则pq在异侧，直接退出循环，返回该root节点
            else
                break;
        }
        return root;
    }
}
