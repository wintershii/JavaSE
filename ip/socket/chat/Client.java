package net.ip.socket.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *  创建客户端 ： 发送数据 + 接收数据
 *  写入数据： 输出流
 *  读取数据： 输入流
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost",10086);

        //输出流
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        dos.writeUTF(str);
        dos.flush();


        //输入流：
        DataInputStream dis = new DataInputStream(client.getInputStream());
        String msg = dis.readUTF();
        System.out.println(msg);
    }
}
