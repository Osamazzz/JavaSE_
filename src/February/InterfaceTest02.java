package February;

public class InterfaceTest02 {
    public static void main(String[] args) {
        //接口多态体现:接口引用可以指向实现了接口的类的对象实例
        USB usb = new IPhone();
        usb = new HuaWei();
        //继承体现多态:父类类型的变量a02可以指向继承了A02的子类的对象实例
        A02 a02 = new A02();
        a02 = new B02();
        //还可以实现多态数组
        USB[] usbs = new USB[2];
        usbs[0] = new IPhone();
        usbs[1] = new HuaWei();
        //遍历usbs数组，如果是IPhone类型，那么除了要实现work方法还要实现IPhone特有的方法
        for (int i = 0; i < usbs.length; i++) {
            usbs[i].work();//动态绑定机制
            //instanceof判断的是运行类型(内存地址)
            if (usbs[i] instanceof IPhone) {
                ((IPhone)usbs[i]).siri();
            }
        }
    }
}

interface USB{
    void work();
}
class IPhone implements USB{
    @Override
    public void work() {
        System.out.println("苹果手机开始工作");
    }
    public void siri() {
        System.out.println("Hi,Siri!");
    }
}
class HuaWei implements USB{
    @Override
    public void work() {
        System.out.println("华为不卡");
    }
}

class A02 {
}
class B02 extends A02 {
}