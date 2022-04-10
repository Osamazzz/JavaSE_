package LeetCode_.LinkList;

/**
 * @author Obamazzz
 * @version 1.0
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 */
public class getKthFromEndTest {
    public ListNode getKthFromEnd(ListNode head, int k) {
        int count = 0;//记录走过了几个节点
        ListNode cur = head;
        ListNode res = null;
        while (cur != null) {
            if (res != null) {
                res = res.next;
            }
            if (k - 1 == count) {
                res = head;
            }
            count++;
            cur = cur.next;//cur总是先动
        }
        return res;
    }

    public ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode former = head, latter = head;
        for(int i = 0; i < k; i++)
            former = former.next;
        while(former != null) {
            former = former.next;
            latter = latter.next;
        }
        return latter;
    }
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
