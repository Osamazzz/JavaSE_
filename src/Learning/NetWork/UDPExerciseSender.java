package Learning.NetWork;

import java.io.IOException;
import java.net.*;

public class UDPExerciseSender {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(18888);
        byte[] bytes = "四大名著是哪些".getBytes();
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 8888);
        datagramSocket.send(packet);
        // 等待接收端回传信息
        byte[] revBuf = new byte[1024];
        DatagramPacket recPacket = new DatagramPacket(revBuf, revBuf.length);
        datagramSocket.receive(recPacket);

        int len = recPacket.getLength();
        byte[] bytes1 = recPacket.getData();
        System.out.println(new String(bytes1, 0, len));
        // 关闭流
        datagramSocket.close();
        System.out.println("发送端退出");

    }
}
