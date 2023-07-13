package newStart;

public class Test3 {
    public static void main(String[] args) {
//        Person p1 = new Person();
//        Person p2 = func01(p1);
//        System.out.println(p1);
//        System.out.println(p2);
    }
    public static Person func01(Person p1) {
        return p1;
    }
}

abstract class Person {
    Person() {

    }

    abstract public void test();
}

class ddd extends Person {

    @Override
    public void test() {

    }
}