package Learning.File;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {
    public static void main(String[] args) {

    }

    /**
     * 使用FileOutputStream 将数据写到文件中，
     * 如果文件不存在，则创建该文件
     */
    @Test
    public void writeFile() {
        String filePath = "D:\\FileTest\\a.txt";
        // 创建FileOutputStream
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(filePath);
            // 以下写法会覆盖写入文件
            // 下面这样写会追加写入不覆盖
//            fileOutputStream = new FileOutputStream(filePath, true);
            // 写入一个字节
//            fileOutputStream.write('a');
            // 写入一个字符串
            String str = "hello, world ";
            // getBytes方法将字符串转成字节数组
            fileOutputStream.write(str.getBytes());
            fileOutputStream.write(str.getBytes(), 0, 5);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
