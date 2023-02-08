package LeetCode_.LinkList;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Obamazzz
 * @version 1.0
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，
 * 每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 */
public class copyRandomListTest {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node p = head;
        Map<Node, Node> map = new HashMap<>();
        while (p != null) {
            map.put(p, new Node(p.val));
            p = p.next;
        }
        //再次遍历链表
        p = head;
        while (p != null) {
            //修改map中value的next和random
            //get方法返回value -> map.get(p)得到的是new后的Node(p.val)
            map.get(p).next = map.get(p.next);
            map.get(p).random = map.get(p.random);
            p = p.next;
        }
        return map.get(head);
    }

    public Node copyRandomList2(Node head) {
        if(head == null)
            return null;
        Node cur = head;
        // 1. 复制各节点，并构建拼接链表
        while(cur != null) {
            Node tmp = new Node(cur.val);
            tmp.next = cur.next;
            cur.next = tmp;
            cur = tmp.next;
        }
        // 2. 构建各新节点的 random 指向
        cur = head;
        while(cur != null) {
            if(cur.random != null)
                //cur.random.next即为新构造的原节点指向的random节点
//                cur.next即为复制的cur节点
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        // 3. 拆分两链表
        cur = head.next;
        Node pre = head, res = head.next;
        while(cur.next != null) {
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = null; // 单独处理原链表尾节点
        return res;      // 返回新链表头节点
    }
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}

