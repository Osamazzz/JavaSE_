package Collection_.Set;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class HashSetStructure {
    public static void main(String[] args) {
        // 模拟hashset底层(HMap)->(数组+链表+红黑树)
        Node_[] table = new Node_[16];
        // 创建结点
        Node_ john = new Node_("john", null);
        table[2] = john;
        Node_ jack = new Node_("jack", null);
        john.next = jack;//将jack结点挂载到john上
        Node_ rose = new Node_("rose", null);
        jack.next = rose;
    }
}
//结点类，用来存放数据，可以指向下一个结点，形成链表
class Node_ {
    Object item;//数据
    Node_ next;//指向下一个结点

    public Node_(Object item, Node_ next) {
        this.item = item;
        this.next = next;
    }
}
