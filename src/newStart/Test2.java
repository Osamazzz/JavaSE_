package newStart;

/**
 * @author Obamazzz
 * @version 1.0
 */
public class Test2 {
    public static void main(String[] args) {

    }
}

abstract class Animal {
    private String name;

    public Animal() {

    }

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
    public Cat() {

    }
    public Cat(int num) {
        this();
    }
    @Override
    public void eat() {
        System.out.println("猫吃猫粮");
    }
}

