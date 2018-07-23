package net.ip.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *  1.创建客户端  必须指定服务器 + 端口  此时就在连接
 *          Socket(String host, int port)
 */
public class Client {

    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost",8888);

        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String str = br.readLine();     //阻塞式方法
        System.out.println(str);

    }
}
