package DS.BinaryTree_;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class LevelOrderTest {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // List<List<Integer>>可以理解为一个二维数组
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // LinkedList实现队列
        Queue<TreeNode> queue = new LinkedList<>();
        // 先将根节点放入队列
        queue.add(root);
        while (queue.size() > 0) {
            int size = queue.size();
            //结果临时保存至temp中
            List<Integer> temp = new ArrayList<>();
            // 遍历队列，把当前层的元素从队列取出来，将下一层放入队列
            for (int i = 0; i < size; i++) {
                // 取出队列元素，放入集合
                TreeNode current = queue.poll();
                //空指针异常
                assert current != null;
                temp.add(current.val);
                if (current.left != null) {
                    // 将当前节点的左儿子放入队列
                    queue.add(current.left);
                }
                if (current.right != null) {
                    // 将当前节点的右儿子放入队列
                    queue.add(current.right);
                }
            }
            //将二叉树中第i+1层结果保存至res中
            result.add(temp);
        }
        return result;
    }
}
