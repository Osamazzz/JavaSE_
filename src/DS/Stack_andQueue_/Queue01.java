package DS.Stack_andQueue_;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class Queue01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        LinkedList类实现了Queue接口，因此我们可以把LinkedList当成Queue来用。
        Queue<Integer> queue = new LinkedList<>();
        queue.add(123);
        queue.add(456);
        System.out.println(queue.size());
    }
}
