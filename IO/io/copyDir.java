package com.io;

import java.io.*;
import java.util.Scanner;

/**
 *
 * 1.递归 查找子孙文件/文件夹
 * 2.文件 复制     copyFile
 *   文件夹 创建      mkdirs
 *
 */
public class copyDir {
    public static void main(String[] args) {
        Scanner scan1 = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        System.out.println("请输入要复制的文件夹:");
        String resource = scan1.nextLine();
        System.out.println("请输入要被复制到的路径:");
        String goal = scan2.nextLine();

        try {
            copyDir(new File(resource),new File(goal));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("拷贝失败");
        }

    }

    /**
     * 拷贝文件夹
     * @param resour
     * @param gol
     */
    public static void copyDir(File resour,File gol) throws IOException {
        if(resour.isDirectory()){
            gol = new File(gol,resour.getName());
        }
        copyDirDetail(resour,gol);
    }

    /**
     * 拷贝文件夹细节
     * @param resour
     * @param gol
     */
    public static void copyDirDetail(File resour, File gol) throws IOException {
        if(resour.isFile()){
            copyFile(resour,gol);
        } else if(resour.isDirectory()){
            gol.mkdirs();
            for(File tmp:resour.listFiles()){
                copyDirDetail(tmp,new File(gol,tmp.getName()));
            }
        }
    }


    public static void copyFile(String resource,String goal) throws FileNotFoundException,IOException{
        copyFile(new File(resource),new File(goal));
        }

    public static void copyFile(File resour,File gol)throws FileNotFoundException,IOException{
        InputStream is = null;
        OutputStream os = null;

        is = new BufferedInputStream(new FileInputStream(resour));
        byte[] flush = new byte[1024];
        int len = 0;
        os = new BufferedOutputStream(new FileOutputStream(gol,false));
        while( (len = is.read(flush)) != -1){
         //   System.out.println("Debug");
            os.write(flush,0,len);
        }
        os.flush();
        os.close();
        is.close();
    }

}
