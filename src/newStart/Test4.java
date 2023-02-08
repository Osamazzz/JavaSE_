package newStart;

public class Test4 {
    public static void main(String[] args) {
        B b = new B();
        b.test(100);
    }
}

class A {
    public void test() {
        System.out.println("HELLO");
    }
    public void test(int a) {
        System.out.println("HELLO2");
    }

}

class B extends A {
    @Override
    public void test() {
        super.test();
    }
//    public void test(int a) {
//        super.test();
//    }
}