package net.ip.udp;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * 服务端
 *
 */
public class MyServer {

    public static void main(String[] args) throws IOException {
        //创建服务端
        DatagramSocket server = new DatagramSocket(8888);
        //准备接收容器
        byte[] container = new byte[1024];
        //封装成包
        DatagramPacket pocket = new DatagramPacket(container,container.length);
        //接收数据
        server.receive(pocket);
        //分析数据
        byte[] data = pocket.getData();
//        int len = pocket.getLength();
//        System.out.println(new String(data,0,len));
        double num = convert(data);
        System.out.println(num);
        server.close();
    }

    public static double convert(byte[] data) throws IOException {
        DataInputStream dis = new DataInputStream(new ByteArrayInputStream(data));
        double num = dis.readDouble();
        dis.close();
        return num;
    }
}
