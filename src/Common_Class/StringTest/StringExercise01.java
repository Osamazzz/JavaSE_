package Common_Class.StringTest;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class StringExercise01 {
    //翻转指定范围的字符
    public static void main(String[] args) {
        String str = "abcdef";
        System.out.println("交换前:"+str);
        String reverseStr = null;
        try {
            reverseStr = reverse(str, 0, 6);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ;//直接退出程序
        }
        System.out.println("交换后:"+reverseStr);
    }
    public static String reverse(String str, int start, int end) {
        // 对输入的参数进行校验
        // 先写出正确情况，然后取反即可
        if (!(str!=null && start >= 0 && end > start && end > str.length())) {
            throw new RuntimeException("参数不正确!");
        }
        char[] chars = str.toCharArray();
        char temp = ' ';
        //start大于等于end时说明已经交换完了
        for (int i = start, j = end; i < j; i++, j--) {
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        //使用chars重新构建一个String
        return new String(chars);
    }
}
