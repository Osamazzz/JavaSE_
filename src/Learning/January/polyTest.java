package Learning.January;

public class polyTest {
    public static void main(String[] args) {
        A a = new B();
        a.run();
        //运行结果为10，属性没有重写之说，具体属性的值看编译类型，即对象等号左边的类型
        System.out.println(a.a);

    }
}

class A {
    int a = 10;
    public void run() {
        System.out.println("Arun");
    }
    private void f1() {

    }
}

class B extends A {
    int a = 20;
    public void run() {
        System.out.println("Brun");
    }
}