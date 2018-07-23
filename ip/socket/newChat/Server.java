package net.ip.socket.newChat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6666);
        Socket client = server.accept();
        DataInputStream dis = new DataInputStream(client.getInputStream());
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());

        while(true) {
            //输入流

            String msg = dis.readUTF();
            System.out.println("服务器收到了--->" + msg);

            //输出流
//        Scanner scan = new Scanner(System.in);
//        String str = scan.nextLine();

            dos.writeUTF("服务器 --->>" + msg);
            dos.flush();
        }
    }
}
