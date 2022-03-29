package LeetCode_.StackandQueue;

import java.util.LinkedList;

/**
 * @author Obamazzz
 * @version 1.0
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead操作返回 -1 )
 */
public class CQueue {
    //利用栈 B 删除队首元素：倒序后，B 执行出栈则相当于删除了 A 的栈底元素，即对应队首元素。
    LinkedList<Integer> A, B;
    public CQueue() {
        A = new LinkedList<>();
        B = new LinkedList<>();
    }
    public void appendTail(int value) {
        A.addLast(value);
    }
    public int deleteHead() {
        if(!B.isEmpty()) return B.removeLast();
        if(A.isEmpty()) return -1;
        while(!A.isEmpty())
            B.addLast(A.removeLast());
        return B.removeLast();
    }
}
