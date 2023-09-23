package Learning.File;


import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;

public class FileReader_ {
    public static void main(String[] args) {

    }

    @Test
    public void test01() {
        String filePath = "D:\\FileTest\\b.txt";
        FileReader fileReader = null;
        int data = 0;
        // 1.创建FileReader对象
        try {
            fileReader = new FileReader(filePath);
            // 循环读取
            while ((data = fileReader.read()) != -1) {
                System.out.println((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test02() {
        String filePath = "D:\\FileTest\\b.txt";
        FileReader fileReader = null;
        int readLen = 0;
        char[] buf = new char[8];
        // 1.创建FileReader对象
        try {
            fileReader = new FileReader(filePath);
            // 循环读取,返回实际读取到的字符数，-1为结尾
            while ((readLen = fileReader.read(buf)) != -1) {
                System.out.print(new String(buf, 0, readLen));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
