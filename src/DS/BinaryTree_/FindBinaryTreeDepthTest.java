package DS.BinaryTree_;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class FindBinaryTreeDepthTest {
    public static void main(String[] args) {

    }

    //后序遍历寻找树的最大深度
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;//递归方法一定要有个边界条件
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;//递归体
    }
    //前序遍历寻找树的最大深度
    int ans = 0;
    public void maxDepth(TreeNode root, int depth) {
        if (root == null) {
            return ;
        }
        //叶子结点
        if (root.left == null && root.right == null) {
            ans =  Math.max(ans,depth);//更新结果
        }
        maxDepth(root.left,depth+1);
        maxDepth(root.right,depth+1);
    }
}
