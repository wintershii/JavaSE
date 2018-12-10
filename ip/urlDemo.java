package net.ip;

import java.net.MalformedURLException;
import java.net.URL;

/**
 *  URI 统一资源标识符 用来唯一的标识一个资源
 *  URL 统一资源定位符 睡觉哦一种具体的URI
 *
 *  四部分组成： 协议 存放资源的主机域名  端口  资源文件名 (/)
 *
 *  URL :
 *     1.创建
 *     2.方法
 *
 */
public class urlDemo {
    public static void main(String[] args) throws MalformedURLException {
        //绝对路径构建
        URL url = new URL("http://www.baidu.com:80/index.html#aa");

        System.out.println("协议：" + url.getProtocol());
        System.out.println("域名：" + url.getHost());
        System.out.println("端口：" + url.getPort());
        System.out.println("资源：" + url.getFile());
        System.out.println("相对路径：" + url.getPath());
        System.out.println("锚点：" + url.getRef());
        System.out.println("参数：" + url.getQuery());  // 存在锚点时返回null

        url = new URL(url,"b.txt");    //相对路径

        System.out.println(url.toString());
    }

}
