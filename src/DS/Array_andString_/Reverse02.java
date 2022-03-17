package DS.Array_andString_;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class Reverse02 {
    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        reverseString(s);
        for (char c : s) {
            System.out.print(c);
        }

    }
    public static void reverseString(char[] s) {
        int head = 0;
        int tail = s.length - 1;
        while (head < tail) {
            char temp = s[head];
            s[head] = s[tail];
            s[tail] = temp;
            head++;
            tail--;
        }
    }
}
