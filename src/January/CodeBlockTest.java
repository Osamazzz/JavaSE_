package January;

public class CodeBlockTest {
    public static void main(String[] args) {
        test2 a1 = new test2();
        test2 a2 = new test2();
        System.out.println("================");
        System.out.println(abc.age);//可以看到abc的父类中的静态代码块被执行了，而abc类的普通代码块并没有执行
        new abc();//普通代码块执行了。。。
    }
}

class ABC2{
    //体会public static int age = 18;放在ABC2和abc中的区别
    public static int age = 18;
    static {
        System.out.println("ABC2的静态代码块被执行。。。");
    }
    {
        System.out.println("ABC2的普通代码块被执行。。。");
    }

}

class abc extends ABC2 {
    public static int age = 18;
    //静态代码块
    static {
        System.out.println("abc的静态代码块被执行。。。");
    }
    //普通代码块
    {
        System.out.println("abc的普通代码块被执行。。。");
    }

    public abc() {
        //①隐藏了super();
        //②调用本类普通代码块
        //③最后执行构造器的内容
        System.out.println("abc构造器被调用");
    }
}

class test2{

    public String str;
    public static int a = geta();//按顺序首先进行静态属性的初始化
    //不管调用哪个构造器，都会先调用代码块中的内容
    {
        System.out.println("test2的普通代码块被执行。。。");
    }

    //静态代码块作用是对类进行初始化，随着类的加载而执行，且只会执行一次
    //如果是普通代码块，每创建一个对象就会执行一次
   static {
        System.out.println("test2的静态代码块被执行。。。");
    }

    public test2() {
        System.out.println("空参构造器被调用");
    }

    public static int geta() {
        System.out.println("geta被调用了。。。");
        return 100;
    }
}