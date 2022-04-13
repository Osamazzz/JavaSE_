package LeetCode_.DoublePointer;

/**
 * @author Obamazzz
 * @version 1.0
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串"I am a student. "，则输出"student. a am I"。
 */
public class reverseWordsTest {
    public static void main(String[] args) {
        System.out.println(new reverseWordsTest().reverseWords("   "));
    }
    public String reverseWords(String s) {
        if (s.length() == 0) return "";
        String[] strings = s.split(" ");
        if (strings.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = strings.length - 1; i >= 1; i--) {
            if (!strings[i].equals(""))
                sb.append(strings[i]).append(" ");
        }
        if (!strings[0].equals(""))
            sb.append(strings[0]);
        //检查结尾
        String s1 = sb.toString();
        String res;
        if (s1.charAt(s1.length() - 1) == ' ')
            res = s1.substring(0, s1.length() - 1);
        else res = s1;
        return res;
    }
    public String reverseWords2(String s) {
        s = s.trim();                                    // 删除首尾空格
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') i--;     // 搜索首个空格
            res.append(s.substring(i + 1, j + 1) + " "); // 添加单词
            while (i >= 0 && s.charAt(i) == ' ') i--;     // 跳过单词间空格
            j = i;                                       // j 指向下个单词的尾字符
        }
        return res.toString().trim();                    // 转化为字符串并返回
    }
}
