package LeetCode_.LinkList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Obamazzz
 * @version 1.0
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 */
public class mergeTwoListsTest {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dum = new ListNode(0), cur = dum;
        //当l1和l2都被取光时退出循环
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return dum.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        List<Integer> list = new ArrayList<>();
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while (cur1 != null || cur2 != null) {
            if (cur1 != null) {
                list.add(cur1.val);
                cur1 = cur1.next;
            }
            if (cur2 != null) {
                list.add(cur2.val);
                cur2 = cur2.next;
            }
        }
        //排序
        Collections.sort(list);
        ListNode newList = new ListNode(list.get(0));
        ListNode r = newList;
        for (int i = 1; i < list.size(); i++) {
            ListNode cur = new ListNode(list.get(i));
            r.next = cur;
            r = cur;
        }
        return newList;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
