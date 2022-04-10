package LeetCode_.LinkList;

/**
 * @author Obamazzz
 * @version 1.0
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点
 */
public class deleteNodeTest {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            //如果头结点为所要找的结点
            if (head.val == val) {
                head = head.next;
                break;
            }
            if (cur.val == val) {
                pre.next = cur.next;
                cur = null;//help GC
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        return head;
    }
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
