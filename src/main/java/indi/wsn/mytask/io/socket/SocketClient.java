package indi.wsn.mytask.io.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 类的描述
 *
 * @author Administrator
 * @Time 2012-11-2014:49:01
 */
public class SocketClient {
    private static final int PORT = 3000;

    public static void main(String[] args) throws IOException {

        int  i= 0;
        while(i<100000) {
            Socket socket = new Socket(InetAddress.getLocalHost(), PORT);
            PrintWriter writer = null;
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

                writer.println("end");
                System.out.println(System.currentTimeMillis());

                String str = reader.readLine();

                System.out.println(str);
            } finally {
                socket.close();
            }
            i++;
        }
    }
}
