package Common_Class.StringTest;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class StringExercise02 {
    public static void main(String[] args) {
        countStr("123abcABC  ");
    }
    public static void countStr(String str) {
        int countNum = 0;
        int countUpper = 0;
        int countLower = 0;
        int other = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                countNum++;
            } else if (Character.isUpperCase(str.charAt(i))) {
                countUpper++;
            } else if (Character.isLowerCase(str.charAt(i))) {
                countLower++;
            } else {
                other++;
            }
        }
        System.out.println("num:" + countNum);
        System.out.println("upper:" + countUpper);
        System.out.println("lower:" + countLower);
        System.out.println("other:" + other);
    }
}
