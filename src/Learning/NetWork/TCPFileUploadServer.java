package Learning.NetWork;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 文件上传的服务端
 */
public class TCPFileUploadServer {
    public static void main(String[] args) throws IOException {
        // 服务器在本机监听8888端口
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务器在8888端口监听...");
        // 等待客户端连接
        Socket socket = serverSocket.accept();
        // 读取客户端发送的数据
        BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
        byte[] receiveBytes = TCPFileUploadClient.streamToByteArray(bufferedInputStream);
        // 将数组写入到指定路径
        String filePath = "d:\\FileTest\\dog2.jpeg";
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(filePath));
        bufferedOutputStream.write(receiveBytes);
        bufferedOutputStream.close();
        // 向客户端回复,用处理字符类
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("收到图片");
        bufferedWriter.flush();// 手动刷新
        socket.shutdownOutput();// 设置结束标志
        bufferedWriter.close();
        // 关闭其他流
        bufferedInputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务器关闭");
    }
}
