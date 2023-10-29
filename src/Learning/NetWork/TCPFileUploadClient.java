package Learning.NetWork;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 文件上传的客户端
 */
public class TCPFileUploadClient {
    public static void main(String[] args) throws Exception {
        // 连接服务器8888端口，得到socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        // 创建读取磁盘文件的输入流
        String filePath = "d:\\FileTest\\dog.jpeg";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));
        // 将文件转换为字节数组
        byte[] bytes = streamToByteArray(bis);
        // 通过socket获取一个输出流，将数组传输给服务器
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        // 将文件对应的字节数组写入到数据通道中
        bos.write(bytes);
        bis.close();
        // 设置结束标志
        socket.shutdownOutput();
        // 接受从服务端接收的消息
        InputStream inputStream = socket.getInputStream();
        System.out.println(streamToString(inputStream));
        // 关闭流
        bos.close();
        socket.close();
    }

    /**
     * 将输入流转换成byte[]
     */
    public static byte[] streamToByteArray(InputStream is) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = is.read(buf)) != -1) {
            // 把读取到的数据写入到bos中
            bos.write(buf, 0, readLen);
        }
        byte[] returnArray = bos.toByteArray();
        // 关闭流
        bos.close();
        return returnArray;
    }
    public static String streamToString(InputStream is) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line + "\r\n");
        }
        return sb.toString();
    }

}
