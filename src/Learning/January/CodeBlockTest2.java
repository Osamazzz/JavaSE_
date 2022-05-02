package Learning.January;


public class CodeBlockTest2 {
    public static void main(String[] args) {
        System.out.println(AAA.a);
        System.out.println("=======================");
        //父类静态代码块->子类静态代码块->(父类普通代码块->父类构造器)->(子类普通代码块->子类构造器)
        new BBB();
    }
}

class AAA {
    public static int a = 100;
    static {
        System.out.println("AAA的静态代码块被执行。。。");
    }
    {
        System.out.println("AAA的普通代码块被执行。。。");
    }

    public AAA() {
        System.out.println("AAA构造器被调用");
    }
}

class BBB  extends AAA {
    static {
        System.out.println("BBB的静态代码块被执行。。。");
    }
    {
        System.out.println("BBB的普通代码块被执行。。。");
    }

    public BBB() {
        //①先super();
        //②调用本类普通代码块
        //③最后执行构造器的内容
        System.out.println("BBB构造器被调用");
    }
}
