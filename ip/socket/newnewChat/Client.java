package net.ip.socket.newnewChat;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost",6666);
        //客户端发送
        new Thread(new Send(client)).start();
        //客户端接收
        new Thread(new Receive(client)).start();
    }
}
