package Learning.Reflection;

import LeetCode_.Sort.MedianFinder;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest02 {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        m1();
        m2();
    }

    // 传统方法
    public static void m1() {
        Cat cat = new Cat();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 90000000; i++) {
            cat.hi();
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时为" + (end - start));
    }

    // 反射方式->解释执行，效率低
    // 关闭访问检查可以提高效率
    public static void m2() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> aClass = Class.forName("Learning.Reflection.Cat");
        Object o  = aClass.newInstance();
        Method hi = aClass.getMethod("hi");
        // 关闭访问检查
        hi.setAccessible(true);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 90000000; i++) {
            hi.invoke(o);
        }
        long end = System.currentTimeMillis();

        System.out.println("耗时为" + (end - start));
    }
}
