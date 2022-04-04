package LeetCode_.Divide;

import DS.BinaryTree_.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class buildTreeTest {
    //不适用于节点值重复的二叉树
    public int[] preorder;
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            //建立value-index键值对
            map.put(inorder[i], i);
        }
        return divide(0, 0, inorder.length - 1);
    }
    public TreeNode divide(int rootValue, int left, int right) {
        //如果左边界大于右边界，那么递归结束
        if (left > right)
            return null;
        TreeNode root = new TreeNode(preorder[rootValue]);
        //获取根节点值在中序遍历中的索引
        int index = map.get(preorder[rootValue]);
        root.left = divide(rootValue + 1, left, index - 1);
        root.right = divide(index - left + rootValue + 1, index + 1, right);
        return root;
    }

    public int[] inorder;
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        return divide2(0, 0, inorder.length - 1);
    }
    public TreeNode divide2(int rootValue, int left, int right) {
        //如果左边界大于右边界，那么递归结束
        if (left > right)
            return null;
        TreeNode root = new TreeNode(preorder[rootValue]);
        //获取根节点值在中序遍历中的索引
        int index = search(inorder, preorder[rootValue]);
        root.left = divide2(rootValue + 1, left, index - 1);
        root.right = divide2(index - left + rootValue + 1, index + 1, right);
        return root;
    }
    public int search(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }
}
