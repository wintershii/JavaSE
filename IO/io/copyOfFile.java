package com.io;

import java.io.*;
import java.util.Scanner;

public class copyOfFile {
    public static void main(String[] args) {
        Scanner scan1 = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);

        System.out.println("请输入要复制的文件路径：");
        String resource  = scan1.nextLine();
        System.out.println("请输入复制后的文件路径:");
        String goal = scan2.nextLine();

        File resour = new File(resource);
        File gol = new File(goal);

        InputStream is = null;
        OutputStream os = null;

        try {
            is = new BufferedInputStream(new FileInputStream(resour));

            byte[] flush = new byte[1024];
            int len = 0;
            os = new BufferedOutputStream(new FileOutputStream(gol,false));
            while( (len = is.read(flush)) != -1){
                System.out.println("Debug");
                os.write(flush,0,len);
            }
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("未找到要复制的文件!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("打开文件失败！");
        }finally {
            try {
                os.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("关闭文件失败");
            }

        }

    }
}
