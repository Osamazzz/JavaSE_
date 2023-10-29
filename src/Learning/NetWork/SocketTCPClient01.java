package Learning.NetWork;



import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketTCPClient01 {
    public static void main(String[] args) throws IOException {
        // 客户端
        // 连接服务器,使用InetAddress.getLocalHost()获取本地ip
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("socket = " + socket.getClass());

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello, server".getBytes());
        // 设置写入结束标志
        socket.shutdownOutput();

        // 获取输入流
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buf)) != -1) {
            System.out.println(new String(buf, 0, readLen));
        }
        outputStream.close();
        socket.close();
        System.out.println("客户端退出");

    }
}
