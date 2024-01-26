package Learning.Reflection;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 反射机制可以完成
 * 在运行时判断任意一个对象所属的类
 * 在运行时构造任意一个类的对象
 * 在运行时得到任意一个类所具有的成员变量和方法
 * 在运行时调用任意一个对象的成员变量和方法
 */
public class ReflectionTest01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        // 使用properties类读写配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\re.properties"));
        String classFullPath = properties.get("classFullPath").toString();
        String method = properties.get("method").toString();
        System.out.println("classFullPath" + classFullPath);
        System.out.println("method" + method);

        // 利用反射机制创建对象
        // 加载类，返回class类型的对象
        Class<?> aClass = Class.forName(classFullPath);
        // 通过这个对象可以得到你要加载的类的实例对象
        Object cat =  aClass.newInstance();
        System.out.println("cat的运行类型" + cat.getClass());
        // 通过aClass得到你加载类的方法对象
        // 在反射中可以把方法都视为对象！
        Method method1 = aClass.getMethod(method);
        // 通过method1调用方法，即通过方法对象来实现调用方法
        // 传统方法是对象.方法名()，在反射里面变成了方法.invoke(对象)
        // 这种调用方式的好处就是在不修改源码的情况下，只修改配置文件来调用别的方法！
        method1.invoke(cat);
        // 获取构造方法,获取有参构造器
        Constructor constructor = aClass.getConstructor(String.class);
        // 获取成员变量
        // getField不能得到私有的属性
        Field field = aClass.getField("age");
        System.out.println(field.get(cat));// 传统写法为对象.成员变量,这里反过来
    }
}
