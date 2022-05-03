package LeetCode_.LinkList;

import java.util.ArrayList;

/**
 * @author Obamazzz
 * @version 1.0
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 */
public class reverseListTest {
    ListNode res;
    ListNode cur;
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ArrayList<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        res = list.get(list.size() - 1);
        cur = res;
        // 翻转链表
        for (int i = list.size() - 1; i >= 1; i--) {
            cur.next = list.get(i - 1);
            cur = cur.next;
        }
        cur.next = null;//让当初第一个结点指向null
        return res;
    }
    // 双指针
    public ListNode reverseList2(ListNode head) {
        ListNode cur = head, pre = null;
        while (cur != null) {
            ListNode temp = cur.next;//临时变量保存cur
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
