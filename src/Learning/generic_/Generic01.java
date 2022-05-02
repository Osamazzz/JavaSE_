package Learning.generic_;

import java.util.ArrayList;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class Generic01 {
    public static void main(String[] args) {
        // 使用传统的方法解决->泛型
        // 传统方法不能对加入到集合中的数据类型进行约束(不安全)
        // 遍历时需要进行类型转换，如果集合中的数据量较大，会对效率产生影响，不方便
        // 当我们用<Dog>来表示存放到集合中的元素是Dog类型
        // 编译器会进行检测，如果发现添加的类型不满足要求，会报错
        // 遍历时也可以直接取出Dog，而不是Object
        // 这样既提高了安全性，又减少了类型转换的次数，提高效率
        ArrayList<Dog> arrayList = new ArrayList<Dog>();
        arrayList.add(new Dog("john", 10));
        arrayList.add(new Dog("smith", 1));
        arrayList.add(new Dog("yellow", 5));

//        arrayList.add(new Cat("招财猫",5));//不能存放cat
        //for遍历
//        for (Object o : arrayList) {
//            //向下转型
//            Dog dog = (Dog) o;
//            System.out.println(dog.getName() + "-" + dog.getAge());
//            //输出最后一个猫对象会出现类型转换异常
//        }
        for (Dog dog : arrayList) {//取出时不用向下转型，提高效率
            System.out.println(dog.getName() + "-" + dog.getAge());
        }

    }
}

class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Cat {
    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}