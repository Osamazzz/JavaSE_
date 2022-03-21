package DS.BinaryTree_;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {

    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int answer;        // don't forget to initialize answer before call maximum_depth
    // 找到二叉树的最大深度->前序遍历
    public void maximum_depth(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            answer = Math.max(answer, depth);// 相当于return
        }
        maximum_depth(root.left, depth + 1);
        maximum_depth(root.right, depth + 1);
    }
    // 找到二叉树的最大深度->后序遍历
    public int maximum_depth(TreeNode root) {
        if (root == null) {
            return 0;                                   // return 0 for null node
        }
        int left_depth = maximum_depth(root.left);
        int right_depth = maximum_depth(root.right);
        return Math.max(left_depth, right_depth) + 1;	// return depth of the subtree rooted at root
    }
}
class Test {
    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.maximum_depth(root, 0);
        System.out.println(root.answer);
    }
}