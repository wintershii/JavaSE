package net.ip;

import java.io.*;
import java.net.URL;

/**
 *
 * 使用URL 获取资源
 */
public class urlDemo02 {

    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.baidu.com");  //主页  默认资源
        //获取资源  网络流

        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(),"utf-8"));
        char[] flush = new char[1024];
        int len = 0;
        //Writer ow = new BufferedWriter(new FileWriter("d:\\url.txt"));
        BufferedWriter ow = new BufferedWriter(
                            new OutputStreamWriter(new FileOutputStream("d:\\baidu.html"),"utf-8"));
        while(-1 != (len = br.read(flush))){
            String str = new String(flush);
            ow.write(str);
        }
        ow.flush();
        ow.close();
        br.close();

//        InputStream is = url.openStream();
//
//        byte[] flush = new byte[1024];
//        int len = 0;
//        while (-1 != (len = is.read(flush))){
//            System.out.println(new String(flush,0,len));
//        }
//        is.close();

    }
}
