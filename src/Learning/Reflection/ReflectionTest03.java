package Learning.Reflection;

import java.lang.reflect.Field;

public class ReflectionTest03 {
    // Class类也继承Object类
    // 它不是new出来的，而是系统创建的
    // 类对象只会加载一次，调用loadClass方法
    // Class对象是存放在堆中的
    // 使用反射来加载类时是动态加载的
    // 而直接new一个对象是静态加载，依赖性强
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        String classPath = "Learning.Reflection.Cat";
        Class<?> cls1 = Class.forName(classPath);
        // 输出cls1
        System.out.println(cls1);
        System.out.println(cls1.getClass());
        // 得到包名
        System.out.println(cls1.getPackage().getName());
        // 得到类名
        System.out.println(cls1.getName());
        // 创建实例对象
        Object o = cls1.newInstance();
        // 通过反射获取属性brand,但要注意不能是私有的
        Field age = cls1.getField("age");
        System.out.println(age.get(o));
        // 给属性赋值
        age.set(o, 100);
        System.out.println(age.get(o));
        // 还可以获取所有的属性
        Field[] fields = cls1.getFields();
        for (Field f : fields) {
            System.out.println(f.getName());
        }

        System.out.println(A.n2);
    }
}

class A {
    static {
        n2 = 10;
    }
    // n1 是实例属性，不是静态变量。因此在准备阶段不会分配内存
    // n2 是静态变量，分配内存并默认初始化为0，而不是20
    // n3 是常量，和静态变量不一样，会一次性初始化为30
    public int n1 = 10;
    public static int n2 = 20;
    public static final int n3 = 30;

}