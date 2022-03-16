package lanqiaobei.Exercise_;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class Exercise01 {
    public static void main(String[] args) {
        for (int i = 1000; i <= 9999; i++) {
            if (isPalindrome(i)) {
                System.out.println(i);
            }
        }
    }

    //判断是不是回文数
    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        String str = String.valueOf(x);
        int left = 0;//左指针
        int right = str.length() - 1;//右指针
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
