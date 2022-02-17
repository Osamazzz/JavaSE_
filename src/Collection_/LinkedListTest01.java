package Collection_;

import java.util.LinkedList;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class LinkedListTest01 {
    public static void main(String[] args) {
//        LinkedList实现了双向链表和双端队列的特点
//        可以添加任意元素(可以重复)，包括null
//        但是线程不安全，没有实现同步机制
        LinkedList list = new LinkedList();
//        LinkedList底层维护了一个双向的链表
//        LinkedList中维护了两个属性first和last分别指向首节点和尾部节点
//        每个节点(Node对象)里面即维护了prev、next、item三个属性，
//        其中prev指向前一个节点，next指向后一个节点，最终实现双向的链表
//        LinkedList的元素的添加和删除不是通过数组来完成的，相对来说效率较高

//        模拟双向链表
        Node jack = new Node("jack");
        Node tom = new Node("tom");
        Node abc = new Node("abc");

        //连接三个结点
        jack.next = tom;
        tom.next = abc;
        abc.pre = tom;
        tom.pre = jack;

        Node first = jack;//双向链表的头结点
        Node last = abc;//双向链表的尾结点
        //从头到尾遍历
        while (true) {
            if (first == null) {//遍历到尾结点
                break;
            }
            //输出first信息
            System.out.println(first);
            first = first.next;//移动到下一个结点
        }
        System.out.println("==================");
        //从尾到头遍历
        while (true) {
            if (last == null) {//遍历到尾结点
                break;
            }
            //输出first信息
            System.out.println(last);
            last = last.pre;//移动到下一个结点
        }
        //在tom和abc之间添加结点
        Node smith = new Node("smith");
        smith.next = abc;
        smith.pre = tom;
        abc.pre = smith;
        tom.next = smith;
        System.out.println("==================");
        //让first重新指向第一个结点
        first = jack;
        while (true) {
            if (first == null) {//遍历到尾结点
                break;
            }
            //输出first信息
            System.out.println(first);
            first = first.next;//移动到下一个结点
        }
    }
}
//定义一个Node类，Node对象表示双向链表的一个结点
class Node {
    public Object item;//存放数据
    public Node next;//指向后一个结点
    public Node pre;//指向前一个结点

    public Node(Object item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Node{" +
                "item=" + item +
                '}';
    }
}
