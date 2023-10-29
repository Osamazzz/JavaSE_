package Learning.NetWork;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPExerciseReceiver {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(8888);
        byte[] recBuf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(recBuf, recBuf.length);
        System.out.println("接收端等待数据。。。");
        datagramSocket.receive(packet);
        // 收到包后
        int len = packet.getLength();
        byte[] data = packet.getData();
        int port = packet.getPort();
        String addr = String.valueOf(packet.getAddress());
        System.out.println("addr = " + addr);
        String s = new String(data, 0, len);
        byte[] sendBuf;
        if (s.equals("四大名著是哪些")) {
            sendBuf = "四大名著是《红楼梦》等".getBytes();
        } else {
            sendBuf = "what?".getBytes();
        }
        packet = new DatagramPacket(sendBuf, sendBuf.length, InetAddress.getByAddress(packet.getAddress().getAddress()), port);
        datagramSocket.send(packet);
        // 退出
        datagramSocket.close();
        System.out.println("客户端退出");
    }
}
