package LeetCode_.StackandQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class PrintLinkList {
    public int[] reversePrint(ListNode head) {
        ListNode p = head;
        List<Integer> arr = new ArrayList<>();
        while (p != null) {
            arr.add(p.val);
            p = p.next;
        }
        int[] res = new int[arr.size()];
        for (int i = arr.size() - 1, j = 0; i >= 0; i--, j++) {
            res[j] = arr.get(i);
        }
        return res;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
