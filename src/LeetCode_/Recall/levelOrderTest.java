package LeetCode_.Recall;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Obamazzz
 * @version 1.0
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 */
public class levelOrderTest {
    public int[] levelOrder(TreeNode root) {
        List<Integer> res = levelOrderTravel(root);
        if (res == null) {
            return new int[]{};
        }
        int size = res.size();
        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
    public List<Integer> levelOrderTravel (TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //如果队列中还有元素的话
        while (!queue.isEmpty()) {
            int size = queue.size();
            //遍历队列
            for (int i = 0; i < size; i++) {
                //队列元素出队
                TreeNode cur = queue.poll();
                res.add(cur.val);
                //如果当前结点还有子结点,就让子结点入队
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return res;
    }
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        //添加根节点
        queue.offer(root);
        //如果队列中还有元素的话
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            //遍历队列并让队列元素出列
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                temp.add(cur.val);
                //以下顺序不能变
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            res.add(temp);
        }
        return res;
    }
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
   }
}
