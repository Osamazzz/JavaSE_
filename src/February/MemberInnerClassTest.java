package February;

public class MemberInnerClassTest {
    public static void main(String[] args) {
        Outer05 outer05 = new Outer05();
        outer05.m1();
        //外部其他类使用成员内部类的三种方式
        //第一种:相当于把new Inner05()当作是对象outer05的成员
        Outer05.Inner05 inner05 = outer05.new Inner05();
        //第二种:在外部类中编写一个方法可以返回Inner05对象
        Outer05.Inner05 inner051 = outer05.getInner05Instance();
        inner05.say();
        //第三种:第一种和第二种结合
        Outer05.Inner05 inner052 = new Outer05().new Inner05();
    }
}

class Outer05 {
    private int n1 = 100;
    public String name = "John";
    //成员内部类:定义在外部类的成员位置上
    //可以添加任意访问修饰符(public、protected、默认、private)，因为它的地位就是一个成员
    public class Inner05{
        public  int n2 = 200;
        public void say() {
            //可以直接访问外部类的成员
            System.out.println("n1=" + n1 + ", name=" + name);
        }
    }
    public Inner05 getInner05Instance() {
        return new Inner05();
    }
    public void m1() {
        //使用成员内部类
        Inner05 inner05 = new Inner05();
        inner05.say();
    }
}