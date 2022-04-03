package LeetCode_.Recall;

/**
 * @author Obamazzz
 * @version 1.0
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 */
public class IsSubStructure {
    //类似前序遍历
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //如果有一个树为空则返回false
        if (A == null || B == null) {
            return false;
        }
        // 以A为根节点的树包含B，或以A左孩子为根节点的左子树包含B，或以A右孩子为根节点的右子树包含B
        // 以上有一个条件满足即可，故为或的关系
        return recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }
    //剪枝
    public boolean recur(TreeNode A, TreeNode B) {
        // 如果B为null说明已经超过了叶子结点，即匹配完成
        if (B == null) {
            return true;
        }
        //说明匹配到了A的叶子结点仍未完成匹配，即匹配失败
        if (A == null) {
            return false;
        }
        // AB值不同，直接返回false
        if (A.val != B.val) {
            return false;
        }
        return recur(A.left, B.left) && recur(A.right, B.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public boolean isSubStructure2(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }
    boolean recur2(TreeNode A, TreeNode B) {
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}
