package Learning.File;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class propertiesTest {
    public static void main(String[] args) throws IOException {
        // 读取mysql.properties
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\learning\\File\\mysql.properties"));
        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            String[] split = line.split("=");
            System.out.println(split[0] + "的值为" + split[1]);
        }

        bufferedReader.close();

    }

    @Test
    public void test01() {
        // 创建properties
        Properties properties = new Properties();
        // 加载指定配置
        try {
            properties.load(new FileReader("src\\learning\\File\\mysql.properties"));
            // 把k-v显示在控制台
            properties.list(System.out);
            // 根据key获取对应的值
            String pwd = properties.getProperty("pwd");
            String ip = properties.getProperty("ip");
            String user = properties.getProperty("user");
            System.out.println("user = " + user);
            System.out.println("ip = " + ip);
            System.out.println("pwd = " + pwd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
