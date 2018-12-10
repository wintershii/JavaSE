package com.io;

import java.io.*;
import java.util.Scanner;

/**
 * 1.文件---程序---字节数组
 *      > 文件输入流
 *      > 字节输出流
 *
 * 2.字节数组---程序---文件
 *      > 字节输入流
 *      > 文件输出流
 *
 */

public class ByteArrayDemo02 {

    public static void main(String[] args) throws IOException {
//            byte[] data = getBytesFromFile("d:\\test.txt");
//        System.out.println(new String(data));
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        byte[] msg = str.getBytes();
        toFileFromByteArray(msg,"d:\\test.txt");
    }

    public static byte[] getBytesFromFile(String path) throws IOException {
        //创建文件源
        File file = new File(path);
        //创建字节数组目的地
        byte[] dest = null;
        //选择流
        //文件输入流
        InputStream is = new BufferedInputStream(new FileInputStream(file));
        //字节数组输出流不能使多态

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        //操作
        byte[] flush = new byte[1024];
        int len = 0;
        while(-1 != (len = is.read(flush))){
            bos.write(flush,0,len);
        }
        bos.flush();
        dest = bos.toByteArray();
        return dest;
    }

    public static void toFileFromByteArray(byte[] msg,String path) throws IOException {
        InputStream is = new BufferedInputStream(new ByteArrayInputStream(msg));

        byte[] flush = new byte[1024];
        int len = 0;
        while(-1 != (len = is.read(flush))){
            OutputStream os = new BufferedOutputStream(new FileOutputStream(new File(path),true));
            os.write(flush,0,len);
            os.flush();
            os.close();
        }
    }

}
