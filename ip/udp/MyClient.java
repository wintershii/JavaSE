package net.ip.udp;

import javafx.scene.chart.XYChart;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Scanner;

/**
 * 客户端
 *
 *  C/S   局域网
 *  B/S  互联网    http  ftp
 */

public class MyClient {

    public static void main(String[] args) throws IOException {
        //创建客户端
        DatagramSocket client = new DatagramSocket(6666);
        //准备数据
        Scanner scan = new Scanner(System.in);
//        String str = scan.nextLine();
//        byte[] data = str.getBytes();
        double num = scan.nextDouble();
        byte[] data = convert(num);
        //打包
        DatagramPacket pocket = new DatagramPacket(data,data.length,
                                        new InetSocketAddress("localhost",8888));
        //发送
        client.send(pocket);
        //释放
        client.close();
    }

    public static byte[] convert(double num) throws IOException {
        byte[] data = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(bos);

        dos.writeDouble(num);
        dos.flush();

        data = bos.toByteArray();
        return data;
    }
}
