package Learning.NetWork;

import com.sun.xml.internal.ws.util.StreamUtils;

import java.io.IOException;
import java.net.*;

public class DatagramSocketSender {
    public static void main(String[] args) throws IOException {
        // UDP编程中没有明确的客户端和服务端，演变成数据的发送端和接收端
        // 将数据封装到DatagramPacket对象/装包，可以指定端口接受数据
        DatagramSocket datagramSocket = new DatagramSocket(19999);
        // 将需要发送的数据封装到DatagramPacket对象中
        byte[] bytes = "hello 明天吃火锅".getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 9999);
        datagramSocket.send(datagramPacket);
        // 关闭资源
        datagramSocket.close();
        System.out.println("发送端退出");


    }
}
