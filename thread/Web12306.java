package com.thread;

public class Web12306 implements Runnable{
     private int num = 500;
     private boolean flag = true;
    @Override
    public  void run() {
        while (flag){
            test();
        }

    }

    public synchronized void test(){
        if (num <= 0){
            flag = false;
            return;
        }
        System.out.println(Thread.currentThread().getName()+"抢到了"+num--);
    }

    public static void main(String[] args) {
        Web12306 web = new Web12306();

        Thread t1 = new Thread(web,"师东璇");
        Thread t2 = new Thread(web,"曽帅智");
        Thread t3 = new Thread(web,"黄牛");

        t1.start();
        t2.start();
        t3.start();
    }
}
