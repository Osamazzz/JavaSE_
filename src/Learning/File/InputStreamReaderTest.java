package Learning.File;

import org.junit.Test;

import java.io.*;

/**
 * 转换流InputStreamReader的使用
 * 该类为Reader的子类，可以将InputStream(字节流)包装成一个Reader(字符流)
 * 转换流解决中文乱码的问题
 */
public class InputStreamReaderTest {
    public static void main(String[] args) {

    }

    @Test
    public void test01() throws IOException {
        String filePath = "d:\\FileTest\\c.txt";

        // 指定gbk编码,要求源文件为gbk编码，否则一样乱码
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), "gbk");
        // 把InputStreamReader 传入 BufferedReader->更好用，实际开发都用buffered类型的类
        BufferedReader br = new BufferedReader(isr);
        // 读取
        String str = br.readLine();
        System.out.println("读取内容为: " + str);

    }
}
