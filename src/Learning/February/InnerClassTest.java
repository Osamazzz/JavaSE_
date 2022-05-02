package Learning.February;

public class InnerClassTest {
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        outerClass.f1();
        //输出地址哈希
        System.out.println(outerClass);
    }
}

class OuterClass {
    private int n1 = 100;
    private void pf() {
        System.out.println("OuterClass pf()");
    }
    public void f1() {//方法
        //局部内部类是定义在外部类的局部位置，通常在方法内
        class Inner01 {//局部内部类
            private int n1 = 1000;
            //可以直接访问外部类的所有成员，包括私有的
            public void f2() {
                //如果外部类和局部内部类的成员重名时默认遵循就近原则，
                // 如果想访问外部类的成员，可以使用外部类名.this.成员去访问。
                System.out.println("n1 = " + n1 + ", " + "OuterClass.n1 = " + OuterClass.this.n1);
                System.out.println(OuterClass.this);
                pf();
            }
        }
        //外部类要使用内部类则需创建对象
        Inner01 inner01 = new Inner01();
        inner01.f2();
    }
}