package newStart;

import java.util.*;

public class Test7 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int row = 1;//初始化行数为1
        while (!queue.isEmpty()) {
            //先记录此时queue中的剩余节点数
            int size = queue.size();
            //用于存储每一层的节点
            LinkedList<Integer> temp = new LinkedList<>();
            Deque<TreeNode> tempDeque = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur;
                if (row % 2 != 0) cur = queue.pollFirst();
                else cur = queue.pollLast();
                temp.add(cur.val);
                if (cur.left != null) tempDeque.offer(cur.left);
                if (cur.right != null) tempDeque.offer(cur.right);
            }
            queue.addAll(tempDeque);
            ans.add(temp);
            row++;
        }
        return ans;
    }

//    public int[] levelOrder2(TreeNode root) {
//        List<Integer> list = levelOrderTravel(root);
//        if (list == null) return new int[]{};
//        int[] ans = new int[list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            ans[i] = list.get(i);
//        }
//        return ans;
//    }
//
//    public List<Integer> levelOrderTravel(TreeNode root) {
//        if (root == null) return null;
//        List<Integer> list = new ArrayList<>();
//        Queue<TreeNode> myQueue = new LinkedList<>();
//        myQueue.offer(root);
//        while (!myQueue.isEmpty()) {
//            for (int i = 0; i < myQueue.size(); i++) {
//                TreeNode node = myQueue.poll();
//                list.add(node.val);
//                if (node.left != null) {
//                    myQueue.offer(node.left);
//                }
//                if (node.right != null) {
//                    myQueue.offer(node.right);
//                }
//            }
//        }
//
//        return list;
//    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
