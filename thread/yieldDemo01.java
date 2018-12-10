package com.thread;

/**
 * yield : 暂停当前正在执行的线程 并执行其他的线程
 *
 */
public class yieldDemo01 extends Thread{

    public static void main(String[] args) {
        yieldDemo01 demo = new yieldDemo01();
        Thread t = new Thread(demo);
        t.start();

        for (int i = 0; i < 1000; i++){
            if (i % 20 == 0){
                Thread.yield();     //暂停本线程,是静态方法
            }
            System.out.println("main..." + i);
        }

    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++){
            System.out.println("yield ..." + i);
        }
    }
}
