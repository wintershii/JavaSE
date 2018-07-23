package com.thread;

public class ProgrammerApp {

    public static void main(String[] args) {
        //真实角色
        Prorammer pro = new Prorammer();
        //代理角色 + 真实角色引用
        Thread proxy = new Thread(pro);
        //调用.start()启动线程
        proxy.start();

        for (int i =0; i < 100; i++){
            System.out.println("一边唱歌...");
        }
    }
}
