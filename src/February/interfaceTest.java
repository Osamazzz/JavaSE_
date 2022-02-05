package February;

public class interfaceTest {
    public static void main(String[] args) {
        Phone phone = new Phone();
        Computer computer = new Computer();
        computer.work(phone);//把手机接入到电脑
    }
}
//Phone类需实现Interface01接口中规定/声明的方法
class Phone implements Interface01 {
    @Override
    public void start() {
        System.out.println("手机开始工作");
    }
    @Override
    public void stop() {
        System.out.println("手机停止工作");
    }
}

class Computer {
    //形参Interface01是接口类型，可以接收实现了Interface01接口的类的对象实例！
    public void work(Interface01 interface01) {
        interface01.start();
        interface01.stop();
    }
}

class car implements Interface01 {
    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}