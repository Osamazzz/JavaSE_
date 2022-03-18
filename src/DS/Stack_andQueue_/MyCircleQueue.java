package DS.Stack_andQueue_;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Obamazzz
 * @version 1.0
 * 循环队列
 */
public class MyCircleQueue {
    private int[] data;
    private int front;//头指针
    private int rear;//尾指针
    private int Maxsize;

    public MyCircleQueue(int Maxsize) {
        this.Maxsize = Maxsize;
        data = new int[Maxsize];
        front = -1;
        rear = -1;
    }

    public boolean enQueue(int value) {
        if (isFull()) {//如果队列是满的
            return false;
        }
        if (isEmpty()) {//如果队列是空的
            front = 0;
        }
        rear = (rear + 1) % Maxsize;
        data[rear] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (rear == front) {//队列只剩一个元素
            front = -1;
            rear = -1;
            return true;
        }
        front = (front + 1) % Maxsize;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return data[front];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return data[rear];
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return ((rear + 1) % Maxsize) == front;
    }
    public static void main(String[] args) {
        // 1. Initialize a queue.
        Queue<Integer> q = new LinkedList<>();
        // 2. Get the first element - return null if queue is empty.
        System.out.println("The first element is: " + q.peek());
        // 3. Push new element.
        q.offer(5);
        q.offer(13);
        q.offer(8);
        q.offer(6);
        // 4. Pop an element.
        q.poll();
        // 5. Get the first element.
        System.out.println("The first element is: " + q.peek());
        // 7. Get the size of the queue.
        System.out.println("The size is: " + q.size());
    }
}
