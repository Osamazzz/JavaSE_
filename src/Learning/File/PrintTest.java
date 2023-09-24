package Learning.File;

import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class PrintTest {
    public static void main(String[] args) {

    }

    // 测速printStream
    @Test
    public void test01() throws IOException{
        // 字节打印流
        PrintStream out = System.out;
        // 默认情况下输出数据的位置为显示器
        out.println("hello, world");
        // println底层会用write方法
        out.write("lyh,hello".getBytes());
        // 我们还可以修改打印流输出的位置
        System.setOut(new PrintStream("d:\\FileTest\\e.txt"));
        System.out.println("hello");

        out.close();
    }

    // 测速printWriter
    @Test
    public void test02() throws IOException{
        String filePath = "d:\\FileTest\\f.txt";
//        PrintWriter pr = new PrintWriter(System.out);
        PrintWriter pr = new PrintWriter(new FileWriter(filePath));
        pr.print("hi,nihao");
        pr.close();
    }

}
