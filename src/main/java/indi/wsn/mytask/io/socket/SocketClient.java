package indi.wsn.mytask.io.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * FileName: SocketClient.java
 * 客户端
 *
 * @author SharingWoo
 * @version 1.00
 * @Date 2017/4/13
 */
public class SocketClient implements Runnable{
    List<SocketClient> clients = new ArrayList<>(512);
    //socket
    private Socket socket ;
    //数据输入流
    private ObjectInputStream objectInputStream;
    //输出输出流
    private ObjectOutputStream objectOutputStream;
    //连接标志位
    private boolean isConnected;

    public SocketClient(Socket socket) {
        this.socket = socket;
        try {
            //读取service返回的数据
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            //将数据提交service
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            isConnected = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送数据
     * @param t 发送的对象
     * @param <T>
     */
    public<T> void sendInfo(T t) throws Exception {
        if(!(t instanceof Serializable)) {
            throw new Exception("not support serialized!");
        }
        try {
            objectOutputStream.writeObject(t);
        } catch (IOException e) {
            clients.remove(this);
        }
    }
    @Override
    public void run() {
        while(isConnected) {

        }
    }
}
