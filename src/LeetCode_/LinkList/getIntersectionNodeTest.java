package LeetCode_.LinkList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Obamazzz
 * @version 1.0
 * 输入两个链表，找出它们的第一个公共节点。
 */
public class getIntersectionNodeTest {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode curA = headA;
        ListNode curB = headB;
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        while (curA != null || curB != null) {
            if (curA != null) {
                listA.add(curA.val);
                curA = curA.next;
            }
            if (curB != null) {
                listB.add(curB.val);
                curB = curB.next;
            }
        }
        int loopA = listA.size() - 1;
        int loopB = listB.size() - 1;
        int lastVal = -1;
        //从后往前寻找
        while (listA.get(loopA).equals(listB.get(loopB))) {
            lastVal = listA.get(loopA);
            loopA--;
            loopB--;
        }
        if (lastVal == -1) return null;
        curA = headA;
        while (curA.val != lastVal) {
            curA = curA.next;
        }
        return curA;
    }

    //指针 A 先遍历完链表 headA ，再开始遍历链表 headB,走到公共节点走了a+(b−c)
    //指针 B 先遍历完链表 headB ，再开始遍历链表 headA,走到公共节点走了b+(a−c)
    //两链表 有 公共尾部 (即 c > 0) ：指针 A , B 同时指向「第一个公共节点」,此时A==B
    //若两链表 无 公共尾部 (即 c = 0) ：指针 A , B 同时指向 null 。
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B) {//此时指针A和B指向同一个节点，并不只是值相等!!!
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;//返回 A 或 B即可。
    }
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
