package January;

public class staticTest {
    public static void main(String[] args) {
        //静态方法和静态属性可以通过类名.属性名或类名.方法名的方式调用
        System.out.println(test1.a);
        test1.f1();
    }
}

class test1 {
    public static int a;
    private int b;

    public static void f1() {
        //静态方法中不允许存在this或者super关键字
        //System.out.println(this.b);
        //静态方法中只能访问静态变量或者静态方法
        f2();
        //f3();无法访问非静态方法
        //要访问非静态成员时必须创建类的对象后才能访问
        test1 test1 = new test1();
        test1.f3();
        //System.out.println(b);无法访问非静态属性
    }
    public static void f2() {

    }
    public void f3() {
        //普通成员方法可以访问静态和非静态的属性和方法
        System.out.println(b);
        f2();
    }
}