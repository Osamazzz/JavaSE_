package Learning.February;

public class StaticInnerClassTest {
    public static void main(String[] args) {
        Outer06 outer06 = new Outer06();
        outer06.m1();
        System.out.println("======================");
        //外部其他类访问静态内部类
        //方式一：前提是满足访问权限
        Outer06.Inner06 inner06= new Outer06.Inner06();
        inner06.say();
        //方式二：编写一个方法返回对象实例
        Outer06.Inner06 inner061 = outer06.getInstance01();
        inner061.say();
        System.out.println("======================");
        Outer06.Inner06 inner062 = Outer06.getInstance02();
        inner062.say();
    }
}

class Outer06 {
    private int n1 = 100;
    private static String name = "张三";
    private void cry() {

    }
    //静态内部类
    //放在外部类的成员位置，且用static修饰，
    //可以直接访问外部类的静态成员
    static class Inner06 {
        public void say() {
            //不能直接访问外部类的非静态成员！
            //System.out.println(n1);
            System.out.println("name = " + name);
            //不能访问非静态成员cry();
        }
    }
    public void m1() {
        //外部类访问静态内部类：创建对象后再访问
        Inner06 inner06 = new Inner06();
        inner06.say();
    }
    public Inner06 getInstance01() {
        return new Inner06();
    }
    public static Inner06 getInstance02() {
        return new Inner06();
    }
}