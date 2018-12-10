package com.io;


import java.io.*;
import java.util.Scanner;

/**
 * 转换流： 字节转换为字符
 * 1.输入流： InputStreamWriter     解码
 * 2.输出流：OutPutStreamReader     编码
 */
public class converDemo01 {
    public static void main(String[] args) throws IOException {
    //    BufferedReader br = new BufferedReader(new FileReader(new File("d:\\test.txt")));

        BufferedReader bt = new BufferedReader(
                                new InputStreamReader(
                                        new FileInputStream(
                                                new File("d:\\test.txt")),"GBK"));
        String info = null;
        while(null != ( info = bt.readLine())){
            System.out.println(info);
        }


        BufferedWriter writer = new BufferedWriter(
                                    new OutputStreamWriter(
                                            new FileOutputStream(
                                                new File("d:\\test.txt")),"GBK"));
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        writer.write(str);
        writer.flush();
    }
}
