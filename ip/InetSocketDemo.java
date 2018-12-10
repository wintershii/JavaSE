package net.ip;


import java.net.InetSocketAddress;

/**
 *InetSocketAddress 在InetAdddress 的基础上封装了端口
 *  1.创建对象
 *  2.方法
 */
public class InetSocketDemo {
    public static void main(String[] args) {
        InetSocketAddress address = new InetSocketAddress("172.20.10.2",9999);
        System.out.println(address.getHostName());
        System.out.println(address.getPort());
    }
}
