package Learning.File;

import org.junit.Test;

import java.io.*;
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

    @Test
    public void test02() {
        // 使用properties来配置文件
        Properties properties = new Properties();

        // 创建
        properties.setProperty("charset", "utf-8");
        properties.setProperty("user", "tom");
        properties.setProperty("pwd", "abc123");

        // 将k-v存储到文件中即可
        try {
            properties.store(new FileOutputStream("src\\learning\\File\\mysql2.properties"), "hello");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("保存成功");
        // 修改
        properties.setProperty("pwd", "1234560");
        try {
            properties.store(new FileOutputStream("src\\learning\\File\\mysql2.properties"), "hello");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("修改成功");
    }

}
