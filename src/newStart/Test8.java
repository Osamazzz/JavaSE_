package newStart;

public class Test8 {
    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return compare(root.left, root.right);
    }

    public boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        return (left != null && right != null) && (left.val == right.val) && compare(left.left, right.right) && compare(left.right, right.left);
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        return dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean dfs(TreeNode A, TreeNode B) {
        //树B已匹配完成
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return dfs(A.left, B.left) && dfs(A.right, B.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
