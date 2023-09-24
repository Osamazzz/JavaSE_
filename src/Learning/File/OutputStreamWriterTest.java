package Learning.File;

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class OutputStreamWriterTest {
    public static void main(String[] args) {

    }

    @Test
    public void test01() throws IOException {
        String filePath = "d:\\FileTest\\d.txt";

        // 创建
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filePath), StandardCharsets.UTF_8);
        // 写入
        osw.write("hi,lyh您好");
        // 记得关闭流保存
        osw.close();
        BufferedWriter bw = new BufferedWriter(osw);


    }
}
