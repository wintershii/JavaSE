package com.thread;

/**
 * 线程优先级： 代表概率，不是绝对的先后顺序
 *  MAX_PRIORITY   10
 *  MIN_PRIORITY   1
 *  NORM_PRIORITY  5
 *  设置优先级： setPriority()
 *  获取优先级:  getPriority()
 */
public class priority {
    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        Thread p1 = new Thread(t1,"师东璇");
        MyThread t2 = new MyThread();
        Thread p2 = new Thread(t2,"曾帅智");

        p1.setPriority(Thread.MIN_PRIORITY);
        p2.setPriority(Thread.MAX_PRIORITY);

        p1.start();
        p2.start();

        Thread.sleep(100);
        t1.stop();
        t2.stop();
    }
}

class MyThread implements Runnable{
    private boolean flag = true;
    @Override
    public void run() {
        while(flag){
            System.out.println("我是"+Thread.currentThread().getName()+"...");

        }
    }
    public void stop(){
        this.flag = false;
    }
}
