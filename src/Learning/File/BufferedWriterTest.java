package Learning.File;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 用writer或reader不要操作二进制文件，如音频，视频等
 */
public class BufferedWriterTest {
    public static void main(String[] args) {

    }

    @Test
    public void test01() {
        String filePath = "d:\\FileTest\\c.txt";
        BufferedWriter bufferedWriter = null;

        try {
            // 创建bufferedwriter
            bufferedWriter = new BufferedWriter(new FileWriter(filePath));
            // 写入
            bufferedWriter.write("hello,lyh");
            // 换行
            bufferedWriter.newLine();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭流
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
