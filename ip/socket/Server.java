package net.ip.socket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *  1.创建服务器 指定端口    (浏览器是基于TCP 的  客户端)
 *  2.接收客户端的连接  阻塞式
 *  3.发送数据 + 接收数据
 *
 *
 */
public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8888);
        Socket socket = server.accept();
        System.out.println("一个客户端建立连接");    //Request

        String str = "欢迎使用";
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        bw.write(str);
        bw.newLine();
        bw.flush();
    }
}
