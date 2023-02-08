package LeetCode_.Motivation;

import java.util.Stack;

/**
 * @author Obamazzz
 * @version 1.0
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，
 * 序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 */
public class validateStackSequencesTest {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0; // popped指针
        for (int num : pushed) {
            stack.push(num);//pushed元素入栈
            while (!stack.isEmpty() && stack.peek() == popped[i]) { // 栈空或者栈顶元素与将要出栈的元素不相等则不进入
                stack.pop();
                i++;// popped指针下移
            }
        }
        return stack.isEmpty();
    }
}
