package DS.BinaryTree_;

import java.util.*;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {

    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    //层次构造二叉树
    public TreeNode createBinaryTree(ArrayList<Integer> arrayList) {
        if (arrayList.size() == 0 || arrayList.get(0) == null) {
            return null;
        }
        // LinkedList实现队列
        TreeNode root = new TreeNode(arrayList.remove(0));
        Queue<TreeNode> queue = new LinkedList<>();
        //先将根节点放入队列
        queue.offer(root);
        while (arrayList.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                Integer leftValue = null;
                if (arrayList.size() != 0) {
                    leftValue = arrayList.remove(0);
                }
                if (leftValue != null) {
                    temp.left = new TreeNode(leftValue);
                    queue.offer(temp.left);//加入队列
                }
                Integer rightValue = null;
                if (arrayList.size() != 0) {
                    rightValue = arrayList.remove(0);
                }
                if (rightValue != null) {
                    temp.right = new TreeNode(rightValue);
                    queue.offer(temp.right);//加入队列
                }
            }
        }
        return root;
    }
}

class Test {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3, 9, 20, 8, null, 9, 15, 8, null, 9, 10};
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(arr));
        TreeNode tree = new TreeNode();
        TreeNode root = tree.createBinaryTree(arrayList);
        FindBinaryTreeDepthTest test = new FindBinaryTreeDepthTest();
        System.out.println(test.maxDepth(root));
        LevelOrderTest test1 = new LevelOrderTest();
        List<List<Integer>> res = test1.levelOrder(root);
        System.out.println(res);
    }
}