package Learning.NetWork;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class DatagramSocketReceiver {
    public static void main(String[] args) throws IOException {
        DatagramSocket DatagramSocket = new DatagramSocket(9999);
        // 构造一个DatagramPacket对象，准备接收数据
        // UDP一个数据包最大为64K
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        // 调用接收方法,将通过网络传输的DatagramPacket对象填充到packet中
        // 若没有数据则会阻塞
        System.out.println("接收端等待接收数据。。。");
        DatagramSocket.receive(packet);

        // 可以把packet进行拆包，取出数据并显示
        int len = packet.getLength();
        byte[] data = packet.getData();
        String str = new String(data, 0, len);
        System.out.println(str);

        // 关闭资源
        DatagramSocket.close();
        System.out.println("接收端退出");
    }
}
