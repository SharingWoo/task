package indi.wsn.mytask.io.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 类的描述
 *
 * @author Administrator
 * @Time 2012-11-2014:49:01
 */
public class SocketService {
    //设置端口
    private static final int PORT = 3000;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("this server stars successfully.");

        Socket socket = null;
        PrintWriter writer = null;
        while (true) {
            try {
                //持续接收客户端发送的连接

                socket = serverSocket.accept();
                System.out.println("accept the socket from " + socket.getInetAddress() + " " +
                        socket.getLocalAddress());
                //获取socket中的信息
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                while (true) {
                    String string = reader.readLine();
                    if (string.endsWith("end")) {
                        System.out.println("this information is " + string);
                        break;
                    }
                    System.out.println("this information is " + string);
                }
                writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
                writer.println("we have accept the information");
            } finally {
                socket.close();
            }
        }
    }
}
