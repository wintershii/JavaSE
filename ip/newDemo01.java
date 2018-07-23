package net.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * InetAddress  这个类并没有封装端口
 */
public class newDemo01 {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress addr = InetAddress.getLocalHost();
        System.out.println(addr.getHostAddress());
        System.out.println(addr.getHostName());

        addr = InetAddress.getByName("www.163.com");
        System.out.println(addr.getHostAddress());
        System.out.println(addr.getHostName());

        addr = InetAddress.getByName("61.135.253.15");
        System.out.println(addr.getHostAddress());
        System.out.println(addr.getHostName());
    }
}
