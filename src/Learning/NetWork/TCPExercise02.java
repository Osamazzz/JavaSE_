package Learning.NetWork;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPExercise02 {
    // 客户端
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 5020);
        System.out.println(socket.getClass());

        System.out.println("请输入你要问的问题:");
        Scanner in = new Scanner(System.in);
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        InputStream inputStream = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        bw.write(in.nextLine());
        bw.newLine();
        bw.flush();

        // 回显服务器发来的数据
        String s = br.readLine();
        System.out.println(s);

        // 关闭流
        inputStream.close();
        outputStream.close();
        socket.close();
    }
}
