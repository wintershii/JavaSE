package com.io;

import java.io.*;
import java.util.Scanner;

public class Demo02 {
    public static void main(String[] args){
        //建立联系 F
        Scanner scan = new Scanner(System.in);
        String path = scan.nextLine();
        File file = new File(path);
        //选择流 文件输出流
        OutputStream os = null;
        try {
            //以追加形式写出文件
            os = new BufferedOutputStream( new FileOutputStream(file,true));

            Scanner scan2 = new Scanner(System.in);
            String str = scan.nextLine();
            os.write(str.getBytes(),0,str.getBytes().length);

            os.flush();//强制刷新出去
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("文件未找到");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件写入错误");
        }finally {
            if(null != os){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("关闭输出流失败");
                }
            }

        }
    }
}
