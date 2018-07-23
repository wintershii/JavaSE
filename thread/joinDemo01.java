package com.thread;

/**
 * join:合并线程
 *
 */
public class joinDemo01 extends Thread{
    public static void main(String[] args) throws InterruptedException {
        joinDemo01 demo = new joinDemo01();
        Thread t = new Thread(demo); //新生
        t.start();//就绪
        //cpu调度 运行

            for (int i = 0; i < 100; i++){
                if(50 == i){
                    t.join();  //main()阻塞
                }
                System.out.println("main ..." + i);
            }
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            System.out.println("join ..." + i);
        }
    }
}
