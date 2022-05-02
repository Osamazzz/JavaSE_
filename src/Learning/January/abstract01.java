package Learning.January;

public class abstract01 {
    public static void main(String[] args) {

    }
}
//抽象类
abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }
    //抽象方法
    public abstract void eat();
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
    @Override
    public void eat() {
        System.out.println("猫吃猫粮");
    }
}

abstract class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
}

class PPP{
    public static void hhh() {

    }
}
class ZZZZ extends PPP {
    public static void hhh() {

    }
}