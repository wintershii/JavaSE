package com.io;

import java.io.*;
import java.util.Scanner;


/**
 *
 * 纯文本读取
 */
public class Demo_03 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String path = scan.nextLine();
        File file = new File(path);

        try {
            Reader reader = new BufferedReader(new FileReader(file));
            char[] flush = new char[1024];
            int len = 0;
            while (-1 != (len = reader.read(flush))){
                String str = new String(flush,0,len);
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            System.out.println("未找到文件");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
