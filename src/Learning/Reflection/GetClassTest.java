package Learning.Reflection;

public class GetClassTest {
    public static void main(String[] args) throws ClassNotFoundException {
        // 演示得到class对象的各种方式
        // 第一种：通过Class.forName方法获取，多用于配置文件，读取类全路径，加载类
        Class<?> aClass = Class.forName("Learning.Reflection.Cat");
        System.out.println(aClass);
        // 第二种，类名.class,多作为方法的参数传递
        Class<Cat> cls2 = Cat.class;
        System.out.println(cls2);
        // 第三种：通过对象.getClass方法
        Cat cat = new Cat();
        Class<?> cls3 = cat.getClass();
        System.out.println(cls3);
        // 第四种：通过类加载器获取类对象
        ClassLoader classLoader = cat.getClass().getClassLoader();
        Class cls4 = classLoader.loadClass("Learning.Reflection.Cat");
        System.out.println(cls4);
        System.out.println(aClass.hashCode());
        System.out.println(cls2.hashCode());
        System.out.println(cls3.hashCode());
        System.out.println(cls4.hashCode());
        // 基本数据类型也有Class对象
        Class<Integer> integerClass = int.class;
        Class<Boolean> booleanClass = boolean.class;
        Class<int[]> aClass1 = int[].class;
        Class<Integer[]> aClass2 = Integer[].class;
        Class<Integer> type = Integer.TYPE;
        Class<Character> type1 = Character.TYPE;
        System.out.println(type);
        // 注解也有类对象
        Class<Deprecated> deprecatedClass = Deprecated.class;

    }
}
