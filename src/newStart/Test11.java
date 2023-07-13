package newStart;

import java.util.*;

public class Test11 {
    public static void main(String[] args) {

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

    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        recur(root, target);
        return res;
    }

    //先序遍历
    public void recur(TreeNode root, int target) {
        if (root == null) return;
        path.add(root.val);
        target -= root.val;
        //已经找到一条路径
        if (target == 0 && root.left == null && root.right == null)
            //这里必须new一个来保存，因为path为属性，回溯会导致path为空
            res.add(new LinkedList<>(path));
        recur(root.left, target);
        recur(root.right, target);
        //回溯
        path.removeLast();
    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    Node pre, head;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        InOrderTravel(root);
        //修改头尾节点指向
        head.left = pre;
        pre.right = head;
        return head;
    }

    //中序遍历
    public void InOrderTravel(Node cur) {
        if (cur == null) return;
        InOrderTravel(cur.left);
        if (pre == null) {
            head = cur;
        } else {
            pre.right = cur;
            cur.left = pre;
        }
        //更新pre
        pre = cur;
        InOrderTravel(cur.right);
    }

    ArrayList<Integer> find;

    public int kthLargest(TreeNode root, int k) {
        find = new ArrayList<>();
        dfs(root);
        return find.get(k - 1);
    }

    //按照右根左的顺序遍历二叉树
    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right);
        find.add(root.val);
        dfs(root.left);
    }

    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        //dp[i]表示第i天可以获得的最大利润
        int[] dp = new int[prices.length];
        //记录第i天之前的最小价格
        int min = prices[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(prices[i] - min, 0);
            min = Math.min(min, prices[i]);
        }
        int res = Integer.MIN_VALUE;
        for (int i : dp) {
            res = Math.max(res, i);
        }
        return res;
    }
}
