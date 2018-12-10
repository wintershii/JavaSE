package com.io;

import java.io.*;
import java.util.Scanner;

public class Demo01 {
    public static void main(String[] args) {

        //建立联系

        Scanner scan = new Scanner(System.in);
        String path = scan.nextLine();
        File file = new File(path);
        //选择流
        InputStream is = null;
        {
            try {
                is = new BufferedInputStream(new FileInputStream(file));
                //操作不断读取
                byte[] car = new byte[10];
                int len = 0;
                //循环读取
                while (-1 != (len = is.read(car))) {
                    //输出,将字节数组转成字符串
                    String info = new String(car, 0, len);
                    System.out.println(info);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("文件不存在");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("读取文件失败");
            } finally {
                if (null != is) {
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("关闭文件流失败");
                    }
                }

            }
        }
    }
}
