package Learning.NetWork;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 字节流编程
 */
public class SocketTCPServer {
    public static void main(String[] args) throws IOException {
        // 在本机9999端口监听等待连接
        // 这里的serverSocket可以通过accept方法返回多个socket对象
        // 以满足多个客户端连接服务器的需求
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("等待链接中。。。");
        // 当没客户端连接时，程序会阻塞，等待链接
        // 如果有客户端连接，则会返回socket对象，程序继续
        Socket socket = serverSocket.accept();

        System.out.println("socket = " + socket.getClass());

        // IO读取
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buf)) != -1) {
            System.out.println(new String(buf, 0, readLen));
        }
        // 获取输出流
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello, client".getBytes());
        socket.shutdownOutput();
        // 关闭流
        inputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务器关闭");

    }
}
