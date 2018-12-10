package net.ip.udp;

/**
 *
 * UDP: 以数据为中心  非面向链接  不安全  数据可能丢失  效率高
 *    类： DategramSocket  DategramPacket
 *     1. 客户端
 *         1. 创建客户端  创建 DategramSocket 类  + 指定端口(发送端口)
 *         2. 准备数据 字节数组
 *         3. 打包 DatagramPacket + 服务器地址 及 端口
 *         4. 发送
 *         5. 释放资源
 *     2.服务器端
 *         1. 创建服务器端  创建DategramSocket 类  + 指定端口(接收端口)
 *         2. 准备接收容器  字节数组  封装DategramPacket
 *         3. 包 接收数据
 *         4. 分析
 *         5. 释放资源
 */
public class udpDemo {

}
