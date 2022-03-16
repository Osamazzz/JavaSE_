package DS.Array_andString_;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class ReverseWordsTest {
    public static void main(String[] args) {
        String s = "  hello world  ";
        ReverseWordsTest reverseWordsTest = new ReverseWordsTest();
        String res = reverseWordsTest.reverseWords(s);
        System.out.println(res);
    }
    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0, j = strs.length - 1; i <= j; i++, j--) {
            String temp;
            temp = strs[i];
            strs[i] = strs[j];
            strs[j] = temp;
        }
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals(" ")|| strs[i].equals("")) {

            }else {
                sb.append(strs[i]);
                sb.append(" ");
            }
        }
        sb.replace(sb.length() - 1, sb.length(), "");
        return sb.toString();
    }
}
