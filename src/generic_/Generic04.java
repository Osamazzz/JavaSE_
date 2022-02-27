package generic_;

import java.util.List;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class Generic04 {
    public static void main(String[] args) {
        // 泛型不能继承,不能像下面这么做
//        customer<Object, Object, Object> customer = new customer<String,String,String>();
        // 普通成员可以使用泛型(属性、方法)
        // 使用泛型的数组，不能初始化
        // 静态方法中不能使用类的泛型->静态类型与类加载有关，此时对象还没有创建
        // 因此静态方法或者属性使用了泛型，JVM就无法进行初始化
        // 泛型类的类型，是在创建对象时确定的，如果创建对象时没有指定类型，则默认为Object
        String str = method("123", 1);//当调用方法时，传入参数编译器就会确定类型
        System.out.println(str);
    }

    private static String method(String s, int i) {
        return s;
    }

    // 泛型方法可以定义在普通类中，也可以在泛型类中
    // 泛型方法被调用时，类型会确定
    public static <T, R> List<?> method(List<?> t, R r) {

        return t; 
    }
}

class customer<T, R, M> {
    //属性
    String name;
    R r;
    T t;
    M m;
//    static T t;静态类型不能泛型化
    //不能直接实例化，因为在new时需要开辟空间，而T的类型不定，不知道要在内存中开多少空间
    T[] ts;
    //构造器使用泛型

    public customer() {
    }

    public customer(String name, R r, T t, M m) {
        this.name = name;
        this.r = r;
        this.t = t;
        this.m = m;
    }
    //方法使用泛型->该方法不是泛型方法，只是使用了泛型
    public T f1(T t1) {
        return t;
    }
    //静态方法不能泛型化
//    public static void M(M m) {
//
//    }

}

interface c2 extends customInterface<String, Double> {

}

class AA implements c2 {
    @Override
    public Double get(String s) {
        return null;
    }

    @Override
    public void hi(Double aDouble) {

    }
}

class BB implements customInterface<String, Double> {
    @Override
    public Double get(String s) {
        return null;
    }

    @Override
    public void hi(Double aDouble) {

    }
}

interface customInterface<U,R> {
    int age = 10;//public static final int age = 10;
//    U u;不能使用泛型
    // 和类一样，静态成员不能使用泛型
    // 泛型接口的类型在继承接口或实现接口时确定，默认为Object
    R get(U u);
    void hi(R r);
    default R f2(U U) {
        return null;
    }
}