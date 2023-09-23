package Learning.File;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 完成数据拷贝
 */
public class FileCopy {
    public static void main(String[] args) {

    }

    @Test
    public void fileCopy() {
        String srcFilePath = "D:\\FileTest\\a.txt";
        String desFilePath = "D:\\FileTest\\b.txt";
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(srcFilePath);
            fileOutputStream = new FileOutputStream(desFilePath);
            byte[] buf = new byte[1024];
            int readLen = 0;
            while ((readLen = fileInputStream.read(buf)) != -1) {
                // 读取之后就写入文件
                // 不要直接使用write(buf)这个方法
                fileOutputStream.write(buf, 0, readLen);
            }
            System.out.println("拷贝完成");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭输入输出流
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
