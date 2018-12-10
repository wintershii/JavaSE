package net.ip.socket.newnewChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("请输入昵称");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();

        Socket client = new Socket("120.79.196.225",7777);
        //客户端发送
        new Thread(new Send(client,name)).start();
        //客户端接收
        new Thread(new Receive(client)).start();
    }

}
