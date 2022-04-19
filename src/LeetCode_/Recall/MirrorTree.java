package LeetCode_.Recall;

import java.util.*;

/**
 * @author Obamazzz
 * @version 1.0
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 */
public class MirrorTree {
    //方法一:dfs
    public TreeNode mirrorTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        swap(root);
        root.left = mirrorTree1(root.left);
        root.right = mirrorTree1(root.right);
        return root;
    }

    public void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
    //方法二:辅助栈（或队列）
    public TreeNode mirrorTree2(TreeNode root) {
        if(root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        //模拟递归栈
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node.left != null) stack.add(node.left);
            if(node.right != null) stack.add(node.right);
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
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
