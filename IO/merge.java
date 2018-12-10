package com.io;

import java.io.*;

public class merge {

    public static void main(String[] args) {

        try {
            mergeFile("d:\\split","d:\\merge.txt");
            System.out.println("Debug");
        } catch (IOException e) {
            System.out.println("合并失败");
            e.printStackTrace();
        }
    }

    public static void mergeFile(String srcpath,String destPath) throws IOException {
        File src = new File(srcpath);
        File dest = new File(destPath);
        if (dest.isDirectory()){
            System.out.println("目标文件为文件夹");
            return;
        }
            File[] lists = src.listFiles();
        int len = lists.length;
        for (int i = 0; i < len; i++){
            mergeDetail(lists[i],dest);
        }
    }

    public static void mergeDetail(File srcfile,File dest) throws IOException {
        OutputStream os = new BufferedOutputStream(new FileOutputStream(dest,true));
        InputStream is = new BufferedInputStream(new FileInputStream(srcfile));

        byte[] flush = new byte[1024];
        int len = 0;
        while(-1 != (len = is.read(flush))){
            os.write(flush,0,len);
        }
        os.flush();

        is.close();
        os.close();

    }
}
