package February;

public class AnonymousInnerClass {
    public static void main(String[] args) {
        Outer04 outer04 = new Outer04();
        outer04.method();
        //匿名内部类当作实参直接传递，实现代码简化
        f1(new IA() {
               @Override
               public void cry() {
                   System.out.println("cry again!");
               }
           }
        );
    }
    public static void f1(IA ia) {
        ia.cry();
    }
}

class Outer04 {
    private int n1 = 10;
    public void method() {
        //基于接口的匿名内部类
        //tiger编译类型为IA接口
        //运行类型为这个匿名内部类Outer04$1
        IA tiger = new IA() {
            int abc = 10;
            @Override
            public void cry() {
                System.out.println("cry!!" + abc);
            }
        };
        System.out.println("运行类型为：" + tiger.getClass());
        tiger.cry();
        //基于类的匿名内部类
        //father编译类型为father
        //运行类型为Outer04$2
        //注意参数John会传递给Father类的构造器
        Father father = new Father("John") {
            @Override
            public void test() {
                System.out.println("匿名内部类重写了test方法");
            }
        };
        System.out.println("运行类型为：" + father.getClass());
        father.test();
//        想要只调用一次test方法甚至可以
//        new Father("John") {
//            @Override
//            public void test() {
//                System.out.println("匿名内部类重写了test方法");
//            }
//        }.test();
    }
}

interface IA {
    public void cry();
}

class Father {
    private String name;
    public Father(String name) {
        this.name = name;
    }
    public void test() {

    }
}