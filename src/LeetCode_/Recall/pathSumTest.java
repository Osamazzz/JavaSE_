package LeetCode_.Recall;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Obamazzz
 * @version 1.0
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，
 * 找出所有从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点 是指没有子节点的节点。
 */
public class pathSumTest {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target);
        return res;
    }

    public void dfs(TreeNode node, int target) {
        if (node == null)
            return;
        path.add(node.val);
        target -= node.val;
        //将目标路径加入到res中
        if (target == 0 && node.left == null && node.right == null) {
            res.add(new ArrayList<>(path));
        }
        dfs(node.left, target);
        dfs(node.right, target);
        //回溯
        path.remove(path.size() - 1);
    }
    LinkedList<List<Integer>> res2 = new LinkedList<>();
    LinkedList<Integer> path2 = new LinkedList<>();
    public List<List<Integer>> pathSum2(TreeNode root, int sum) {
        recur(root, sum);
        return res2;
    }
    void recur(TreeNode root, int tar) {
        if(root == null) return;
        path2.add(root.val);
        tar -= root.val;
        if(tar == 0 && root.left == null && root.right == null)
            res2.add(new LinkedList(path));
        recur(root.left, tar);
        recur(root.right, tar);
        path2.removeLast();
    }

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
    }
}
