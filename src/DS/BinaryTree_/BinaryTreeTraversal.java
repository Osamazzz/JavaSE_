package DS.BinaryTree_;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class BinaryTreeTraversal {
    public static void main(String[] args) {

    }

    //前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }

    public void preOrder(TreeNode root, List<Integer> res) {
        if (root == null)
            return;//退出preOrder
        //先打印当前节点，然后打印左子树，最后再打印右子树
        res.add(root.val);
        preOrder(root.left, res);
        preOrder(root.right, res);
    }

    //中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrder(root, res);
        return res;
    }

    public void inOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inOrder(root.left, res);
        res.add(root.val);
        inOrder(root.right, res);
    }
    //后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postOrder(root, res);
        return res;
    }
    public void postOrder(TreeNode root, List<Integer> res){
        if (root == null) {
            return;
        }
        postOrder(root.left,res);
        postOrder(root.right,res);
        res.add(root.val);
    }
}
