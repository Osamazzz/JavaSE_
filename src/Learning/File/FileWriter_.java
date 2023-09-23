package Learning.File;

import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriter_ {
    public static void main(String[] args) {

    }

    @Test
    public void test01() {
        String filePath = "D:\\FileTest\\c.txt";
        //创建FileWriter
        FileWriter fileWriter = null;
        char[] chars = {'a', 'b', 'c'};
        try {
            try {
                fileWriter = new FileWriter(filePath);
                // 写入单个字符
                fileWriter.write('H');
                // 写入制定数组
                fileWriter.write(chars);
                // 写入指定数组的指定部分
                fileWriter.write("lyh123".toCharArray(), 0, 3);
                // 写入整个字符串
                fileWriter.write("hello world!");
                // 写入字符串的指定部分
                fileWriter.write("上海添加", 0, 2);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // 一定要关闭,否则白写了
                if (fileWriter != null) {
                    // 关闭文件流等于 flush() + 关闭
                    fileWriter.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
