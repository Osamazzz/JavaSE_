package LeetCode_.StackandQueue;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 */
public class MinStackTest {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.top());
    }
}

class MinStack {
    Stack<Integer> A, B;

    public MinStack() {
        A = new Stack<>();
        //B为非严格降序的栈,存储栈A中所有非严格递减序列
        B = new Stack<>();
    }

    //重点为保持栈B 的元素是 非严格降序 的
    public void push(int x) {
        A.add(x);
        if (B.empty() || B.peek() >= x)
            B.add(x);
    }

    //重点为保持栈A,B 的 元素一致性
    public void pop() {
        if (A.pop().equals(B.peek()))
            B.pop();
    }

    public int top() {
        return A.peek();
    }

    //直接返回B的栈顶元素
    public int min() {
        return B.peek();
    }
}