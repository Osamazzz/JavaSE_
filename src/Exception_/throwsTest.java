package Exception_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class throwsTest {
    public static void main(String[] args) {
        //fileTest方法抛出了一个编译异常，必须解决，这时就要求main方法去处理这个异常
//        fileTest();//抛出异常

        //strTest方法抛出一个运行异常，可以不进行解决，程序会默认使用throws解决
        strTest();
    }
    //使用throws抛出异常(也可以是多个,即抛出多个异常)，让此方法的调用者去处理异常
    public static void fileTest() throws FileNotFoundException/*,NullPointerException*/ {
        //FileNotFoundException
        FileInputStream fis = new FileInputStream("d://aa.txt");//没有此文件
    }
    public static void strTest() throws NullPointerException {
        String name = null;
        System.out.println(name.length());
    }
}
