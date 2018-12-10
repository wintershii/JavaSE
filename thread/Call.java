package com.thread;

import java.util.concurrent.*;

/**
 * 使用Callable + Future 接口 创建线程   优点：(可对外声明异常， 可以获取返回值)
 *
 */
public class Call {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建线程
        ExecutorService ser = Executors.newFixedThreadPool(2);
        //获取值
        Race tortoise = new Race("乌龟",1000);
        Race rab = new Race("兔子",500);
        Future<Integer> result = ser.submit(tortoise);
        Future<Integer> result2 = ser.submit(rab);


        Thread.sleep(2000);
        tortoise.setFlag(false);            //停止线程体循环
        rab.setFlag(false);

        int num = result.get();
        int num2 = result2.get();


        System.out.println("乌龟跑了"+num+"步");
        System.out.println("兔子跑了"+num2+"步");
        //停止服务
        ser.shutdownNow();

    }
}

class Race implements Callable{

    private String name;
    private int time;
    private boolean flag = true;
    private int step = 0; // 第几步
    public Race(String name) {
        this.name = name;
    }

    public Race(String name, int time) {
        this.name = name;
        this.time = time;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public Object call() throws Exception {
        while(flag){
            Thread.sleep(time);
            step++;
        }
        return step;
    }
}