package net.ip.socket.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 创建服务器
 *
 * 输入流与输出流在同一个线程内  应该独立出来
 */
public class Server1 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(10086);
        Socket client = server.accept();
        DataInputStream dis = new DataInputStream(client.getInputStream());
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
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
