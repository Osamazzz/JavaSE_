package LeetCode_.Recall;

/**
 * @author Obamazzz
 * @version 1.0
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 */
public class treeToDoublyListTest {
    Node head = null;//最小值节点
    Node tail = null;//最大值节点
    Node pre = null;//比该节点值小的节点，即上一个节点

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        //中序遍历二叉搜索树,left指向小的节点，right指向大的节点
        inorder(root);
        //检查空指针域，让链表最终成环
        tail.right = head;
        head.left = tail;
        return head;
    }

    //此时树已经成为链表
    public void check(Node root) {
        //最小值节点特征
        if (root.left == null)
            head = root;
        //最大值节点特征
        if (root.right == null)
            tail = root;

    }

    public void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        change(root);
        inorder(root.right);
    }

    public void change(Node node) {
        //防止空指针异常
        if (pre != null)
            pre.right = node;
        node.left = pre;
        //修改完后将其置为pre
        pre = node;
        check(node);
    }

    public Node treeToDoublyList2(Node root) {
        if (root == null) return null;
        dfs(root);
        head.left = pre;
        //最后一次pre肯定指向最后一个节点，即最大的节点
        pre.right = head;
        return head;
    }

    void dfs(Node cur) {
        if (cur == null) return;
        dfs(cur.left);
        if (pre != null) pre.right = cur;
        //这里一开始pre为null，第一次到这里时cur肯定为最小节点，为第一个结点，即head
        else head = cur;//pre == null
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }
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