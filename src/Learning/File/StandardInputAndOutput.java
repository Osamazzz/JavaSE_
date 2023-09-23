package Learning.File;

import java.util.*;
/**
 * System 类的 public final static InputStream in = null
 * System.in 编译类型 InputStream
 * System.in 运行类型 BufferedInputStream
 * 表示的是标准输入 键盘
 *
 * System.out public final static PrintStream out = null;
 * 编译类型 PrintStream
 * 运行类型 PrintStream
 * 表示标准输出 显示器
 */
public class StandardInputAndOutput {
    public static void main(String[] args) {
        System.out.println(System.in.getClass());
        System.out.println(System.out.getClass());
        System.out.println("hello, lyh");

        System.out.println();
        Scanner in = new Scanner(System.in);
        String next = in.next();
        System.out.println(next);
    }


}
