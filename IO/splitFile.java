package com.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class splitFile {
    private String fileName;
    private String path;
    private long blockSize;
    private int size;
    private List<String> blockpath;
    private long length;

    public splitFile() {
        this.blockpath = new ArrayList<String>();
    }


    public splitFile(String path, long blockSize) {
        this();
        this.path = path;
        this.blockSize = blockSize;
        init();
    }

    public void init(){

        File file = null;
        //健壮性
        if(null == path || !(file = new File(path)).exists()){
            System.out.println("文件不存在");
            return;
        }
        if (file.isDirectory()){
            System.out.println("无法分割文件夹");
            return;
        }
        this.fileName = file.getName();
        //计算块数 实际大小 与每块大小
        this.length = file.length();

        if (this.blockSize > length){
            this.blockSize = file.length();
        }

        size = (int)Math.ceil(length*1.0/this.blockSize);

    }

    private void initPathName(String destPath){
        for(int i = 0; i < size; i++){
            this.blockpath.add(destPath+"\\"+fileName+".part"+(i+1));
        }
    }

    /**
     *文件分割
     * 1.分割块数
     * 2.实际大小
     * 3.分割文件存放目录
     * @param
     */
    public void split(String destpath){
        long beginPos = 0;
        long actualBlockSize = blockSize;
        //计算所有块的大小
        initPathName(destpath);
        for (int i = 0; i < size; i++){
            if(i == size - 1){
                actualBlockSize = this.length - beginPos;
                splitDetail(i,beginPos,actualBlockSize);
            }
            splitDetail(i,beginPos,actualBlockSize);
            beginPos += actualBlockSize;
        }
    }

    public void splitDetail(int index,long beginpos,long actualBlockSize){
        //创建源
        File src = new File(this.path);
        File dest = new File(this.blockpath.get(index));

        try (RandomAccessFile raf = new RandomAccessFile(src,"r");
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))){
            //读取文件
            raf.seek(beginpos);
            //缓冲区
            byte[] flush = new byte[1024];
            int len = 0;
            while(-1 != (len = raf.read(flush))) {
               if (actualBlockSize - len >= 0) {
                   bos.write(flush, 0, len);
                   actualBlockSize -= len;
               }else {
                   bos.write(flush, 0, (int)actualBlockSize);
                   break;
               }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        splitFile file = new splitFile("d:\\test.txt",11);
        file.split("d:\\split");
    }



}
