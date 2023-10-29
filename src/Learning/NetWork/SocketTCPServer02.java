package Learning.NetWork;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 字符流编程
 */
public class SocketTCPServer02 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("等待链接中。。。");
        // 当没客户端连接时，程序会阻塞，等待链接
        // 如果有客户端连接，则会返回socket对象，程序继续
        Socket socket = serverSocket.accept();

        System.out.println("socket = " + socket.getClass());

        // IO读取，使用字符流
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String str = bufferedReader.readLine();
        System.out.println(str);//输出
        // 获取输出流，用字符方式
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello,client字符流");
        // 插入换行符
        bufferedWriter.newLine();
        bufferedWriter.flush();// 手动刷新
        // 关闭流
        inputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务器关闭");
    }
}
