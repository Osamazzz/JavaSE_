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
            //get方法返回value
            map.get(p).next = map.get(p.next);
            map.get(p).random = map.get(p.random);
            p = p.next;
        }
        return map.get(head);
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

