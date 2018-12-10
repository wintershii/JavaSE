package com.io;

import java.io.*;
import java.util.Scanner;

public class Demo_04 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String path = scan.nextLine();

        File file = new File(path);

        Writer writer = null;

        try {
            writer = new BufferedWriter( new FileWriter(path));
            Scanner scan2 = new Scanner(System.in);
            String str = scan2.nextLine();
            writer.write(str);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("无法打开此文件");
        }finally {
            if(null != writer){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("文件关闭失败");
                }
            }
        }
    }

}
