package File;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author Obamazzz
 * @version 1.0
 * 创建文件
 */
public class FileCreate {
    public static void main(String[] args) {

    }
    @Test
    //方式1 new File(String pathname)
    public void create01() {
        String filePath = "d:\\news1.txt";
        File file = new File(filePath);
        try {
            file.createNewFile();
            System.out.println("OK");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    //根据父目录文件+子路径创建
    public void create02() {
        File parentFile = new File("d:\\");
        String fileName = "news2.txt";
        //只是一个Java对象
        File file = new File(parentFile, fileName);

        try {
            file.createNewFile();
            System.out.println("OK2");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    // 根据父目录加子路径创建
    public void create03() {
        String parentPath = "d:\\";
        String fileName = "news3.txt";
        //只是一个Java对象
        File file = new File(parentPath, fileName);

        try {
            file.createNewFile();
            System.out.println("OK3");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
