package com.thread;

/**
 * 使用runnable 创建线程   (避免单继承的局限性)  (便于共享资源)
 * 1.类实现Runnable 接口 +重写run()   --->真实角色类
 * 2.启动多线程  使用静态代理
 * 3. 调用.start()方法 启动线程
 */
public class Prorammer implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            System.out.println("一边敲shi dong xuan...");
        }
    }
}
