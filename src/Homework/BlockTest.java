package Homework;

/**
 * 要修饰代码块只能用static
 * 静态代码块会随着类的加载而自动执行,只执行一次
 * 非静态代码块会随着对象的创建而自动执行,每创建一个对象执行一次，可以在创建对象时对属性进行初始化
 */
public class BlockTest {
    public static void main(String[] args) {
        Person person = new Person();
        String test = person.toString();
        System.out.println(test);
    }

}
class Person{
    //属性
    int age;
    String name;

    //构造器
    public Person(){

    }

    //代码块
    {
        System.out.println("block");
    }

    static {
        System.out.println("static!");
    }

    //方法
    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

}

