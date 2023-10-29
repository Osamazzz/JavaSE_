package Learning.NetWork;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPExercise01 {
    // 服务器端
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5020);
        Socket socket = serverSocket.accept();
        System.out.println(socket.getClass());
        // 使用字符流IO读取
        InputStream inputStream = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        String str = br.readLine();
        if (str.equals("name")) {
            bw.write("我是 nova");
        } else if (str.equals("hobby")){
            bw.write("编写java程序");
        } else {
            bw.write("你说啥呢?");
        }
        // 发送结束后输入换行符表示结束
        bw.newLine();
        bw.flush();
        // 关闭流
        br.close();
        bw.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务器关闭");
    }

}
