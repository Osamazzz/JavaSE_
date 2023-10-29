package Learning.NetWork;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketTCPClient02 {
    public static void main(String[] args) throws IOException {
        // 客户端
        // 连接服务器,使用InetAddress.getLocalHost()获取本地ip
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("socket = " + socket.getClass());

        OutputStream outputStream = socket.getOutputStream();
        // 使用转换字符流
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello, server字符");
        bufferedWriter.newLine();// 插入换行符，表示写入结束，但要求对方使用readLine方法来识别
        bufferedWriter.flush();// 必须手动刷新，否则不会写入数据
        // 设置写入结束标志
//        socket.shutdownOutput();

        // 获取输入流
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);
        // 关闭流
        outputStream.close();
        socket.close();
        System.out.println("客户端退出");
    }
}
