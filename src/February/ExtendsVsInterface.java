package February;

import javax.xml.namespace.QName;

public class ExtendsVsInterface {
    public static void main(String[] args) {
        LittleMonkey littleMonkey = new LittleMonkey("WuKong");
        littleMonkey.climbing();
        littleMonkey.swim();
    }
}

//接口
interface FishAble {
    public void swim();
}

//父类继承
class Monkey {
    private String name;

    public Monkey(String name) {
        this.name = name;
    }
    public void climbing() {
        System.out.println(name + "会爬树");
    }

    public String getName() {
        return name;
    }
}

class LittleMonkey extends Monkey implements FishAble{
    public LittleMonkey(String name) {
        super(name);
    }

    @Override
    public void swim() {
        System.out.println(getName() + "通过学习，学会了游泳");
    }
}