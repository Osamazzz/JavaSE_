package Learning.NetWork;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);//DESKTOP-GAI1I0N

        // 根据主机名获取InetAddress对象
        InetAddress host2 = InetAddress.getByName("DESKTOP-GAI1I0N");
        System.out.println(host2);

        //根据域名获取
        InetAddress host3 = InetAddress.getByName("www.baidu.com");
        System.out.println(host3);
    }
}
