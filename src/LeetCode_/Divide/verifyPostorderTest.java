package LeetCode_.Divide;

/**
 * @author Obamazzz
 * @version 1.0
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 */
public class verifyPostorderTest {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }
    public boolean recur(int[] postorder, int left, int right) {
        //left >= right说明子序列节点数小于等于1，直接返回true
        if (left >= right)
            return true;
        int cur = left;
        //左子树的值应小于根节点值
        while (postorder[cur] < postorder[right])
            cur++;
        //寻找 第一个大于根节点 的节点，索引记为 m
        int m = cur;
        //右子树的值应大于根节点值
        while (postorder[cur] > postorder[right])
            cur++;
        // 结束时cur应指向根节点索引，即right
        return cur == right && recur(postorder, left, m - 1) && recur(postorder, m, right - 1);
    }
}
