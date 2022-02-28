package Map_;

import java.util.Properties;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class Properties01 {
    public static void main(String[] args) {
        // Properties类继承hashtable且实现了map接口，也是用K-V来保持数据的
        // 特点和hashtable类似，Properties还可以用于从XXX.properties文件中，
        // 加载数据到Properties类对象，进行修改读取
        Properties properties = new Properties();
        // 增加
        properties.put("john", 123);
        properties.put("smith", 123);
        properties.put("jack", 123);
        properties.put("mike", 123);
//        properties.put(null, 123);error
        System.out.println(properties);
        System.out.println(properties.getProperty("jack"));
    }
}
