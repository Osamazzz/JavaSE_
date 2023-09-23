package Learning.File;

import org.junit.Test;

import java.io.File;

public class DictionaryTest {
    public static void main(String[] args) {

    }

    @Test
    public void m1() {
        String fileName = "d:\\new1.txt";
        File file = new File(fileName);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println(fileName + "删除成功");
            } else {
                System.out.println(fileName + "删除失败");
            }
        } else {
            System.out.println("该文件不存在");
        }
    }

    @Test
    public void m2() {
        String fileName = "d:\\new1";
        File file = new File(fileName);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println(fileName + "删除成功");
            } else {
                System.out.println(fileName + "删除失败");
            }
        } else {
            System.out.println("该目录不存在");
        }
    }

    @Test
    public void m3() {
        String fileName = "d:\\a\\b\\c";
        File file = new File(fileName);
        if (file.exists()) {
            System.out.println("存在");
        } else {
            // 创建多级目录要用mkdirs方法不是mkdir方法
            if (file.mkdirs()) {
                System.out.println("创建成功");
            } else {
                System.out.println("创建失败");
            }
        }
    }

}
