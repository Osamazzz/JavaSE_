package Learning.February;

public class InterfacePolyTest {
    public static void main(String[] args) {
        //接口多态传递现象
        //接口类型的变量可以指向实现了接口的类的对象实例
        USB02 usb02 = new USBTest();
        //如果USB02继承了USB01接口，而USBTest实现了USB02接口
        //那么也相当于USBTest实现了USB01接口
        USB01 usb01 = new USBTest();
    }
}

interface USB01{}
interface USB02 extends USB01{}
class USBTest implements USB02{

}