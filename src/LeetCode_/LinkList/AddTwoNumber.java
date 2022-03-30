package LeetCode_.LinkList;

/**
 * @author Obamazzz
 * @version 1.0
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 */
public class AddTwoNumber {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private ListNode listNode;
    private ListNode t;
    public static void main(String[] args) {
        AddTwoNumber addTwoNumber1 = new AddTwoNumber();
        AddTwoNumber addTwoNumber2 = new AddTwoNumber();
        int[] arr1 = new int[]{9};
        int[] arr2 = new int[]{1,9,9,9,9,9,9,9,9,9};
        addTwoNumber1.createList(arr1);
        addTwoNumber2.createList(arr2);
    }

    public void createList(int[] nums){
        listNode = new ListNode(nums[0]);
        for (int i = 1; i < nums.length; i++) {
           t = new ListNode(nums[i]);
           t.next = listNode;
           listNode = t;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long num = 0;
        long i = 1, j = 1;
        //遍历l1
        while (l1 != null) {
            num += i * l1.val;
            i *= 10;
            l1 = l1.next;
        }
        //遍历l2
        while (l2 != null) {
            num += j * l2.val;
            j *= 10;
            l2 = l2.next;
        }

        ListNode res = new ListNode((int) num % 10);
        if (num < 10) {
            return res;
        }
        num /= 10;
        ListNode rear = res, temp;
        while (num != 0) {
            temp = new ListNode();
            temp.val = (int)num % 10;
            num /= 10;
            rear.next = temp;
            rear = temp;
        }
        return res;
    }
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        //res存放结果，cur为res的尾指针
        ListNode res = new ListNode();
        ListNode cur = res;
        //表示进位
        int carry = 0;
        while (l1 != null || l2 != null){
            //如果其中有一个到达结尾了，那么这个链表这一位的的数字就为0。
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            //两个链表的两位相加
            int sum = a + b + carry;
            //大于10进位
            carry = sum / 10;
            //进位完剩下的余数
            sum %= 10;
            //创建一个节点接入res后面
            cur.next = new ListNode(sum);
            cur = cur.next;
            //分别后移
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        //如果最后还有进位的话，增加一个节点
        if (carry == 1) cur.next = new ListNode(1);
        return res.next;
    }
}