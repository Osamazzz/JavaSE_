package Learning.File;

import org.junit.Test;

import java.io.*;

/**
 * FileInputStream的使用
 */
public class FileInputStreamTest {
    public static void main(String[] args) {

    }

    @Test
    public void readFile01() {
        String filePath = "D:\\FileTest\\hello.txt";
        int readData = 0;
        FileInputStream fileInputStream = null;
        try {
            // 创建文件输入对象，用于读取文件
            fileInputStream = new FileInputStream(filePath);
            // readData读到-1时表示到达文件结尾
            while ((readData = fileInputStream.read()) != -1) {
                System.out.println((char) readData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    // 使用read(byte[])读取

    @Test
    public void readFile02() {
        String filePath = "D:\\FileTest\\hello.txt";
        int readData = 0;
        int len = 0;
        // 一次读取八个字节
        byte[] buf = new byte[8];
        FileInputStream fileInputStream = null;
        try {
            // 创建文件输入对象，用于读取文件
            fileInputStream = new FileInputStream(filePath);
            // readData读到-1时表示到达文件结尾,读到buf那
            // 该方法返回实际读取的字节数
            while ((len = fileInputStream.read(buf)) != -1) {
                System.out.println(new String(buf, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}