package com.thread;

import com.student.Student;

public class Demo_01 {

    public static void main(String[] args) {
        study s = new study();
        Thread t = new Thread(s);
        t.start();

        //外部干涉
        for (int i =0; i < 1000; i++){
            if(i == 500){
                s.stop();
            }
            System.out.println("thread stop ..."+i);
        }
    }
}

class study implements Runnable{
    //线程类中 定义 线程体使用的标识
    private boolean flag = true;

    @Override
    public void run() {
        //线程体使用该标识
        while (flag == true){
            System.out.println("study thread ...");
        }
    }

    //对外提供方法改变标识
    public void stop(){
        this.flag = false;
    }
}
