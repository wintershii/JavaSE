package com.io;

import java.io.*;

/**
 *
 * 字节数组 节点流
 * 数组的长度有限 数据量不会很大
 */
public class ByteArrayDemo01 {
    public static void main(String[] args) throws IOException {
            write();
    }

    public static void write(){
        byte[] msg;

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        String msg2 = "我不是是东轩";
        byte[] flush = msg2.getBytes();
        bos.write(flush,0,flush.length);
        msg = bos.toByteArray();
        String str = new String(msg);
        System.out.println(str);

        try {
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public static void read() throws IOException {
        String msg = "我是是东轩";
        byte[] src = msg.getBytes();

        InputStream is = new BufferedInputStream(
                new ByteArrayInputStream(src));

        byte[] flush = new byte[1024];
        int len = 0;
        while (-1 != (len = is.read(flush))) {
            System.out.println(new String(flush, 0, len));
        }
        is.close();
    }


}
