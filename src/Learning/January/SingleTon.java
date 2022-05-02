package Learning.January;

public class SingleTon {
    public static void main(String[] args) {
        //懒汉式,只有当用户使用getInstance时才返回对象
        //在创建类时没有创建这个对象，可以看到输出Test01.anInt时构造器没有被调用
        System.out.println(Test01.anInt);
        System.out.println("=======================");
        //通过getInstance获取Test01的对象时才会调用构造器
        Test01 test01 = Test01.getInstance();
        System.out.println(test01);

    }
}

class Test01 {
    private String name;
    public static int anInt = 100;
    //1.私有化构造器
    private Test01(String name) {
        System.out.println("构造器被调用");
        this.name = name;
    }
    //2.在类的内部创建一个静态对象，但不调用构造器
    private static Test01 test01 ;
    //3.提供一个公共的静态方法返回这个对象
    public static Test01 getInstance() {
        if (test01 ==null) {//如果还没有创建这个实例对象
            test01 = new Test01("Mike");
        }
        return test01;
    }

    @Override
    public String toString() {
        return "Test01{" +
                "name='" + name + '\'' +
                '}';
    }
}