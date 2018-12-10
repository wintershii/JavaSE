package com.thread;

public class RabbitApp {
    public static void main(String[] args) throws InterruptedException {
        Rabbit rab = new Rabbit();
        Tortoise tor = new Tortoise();
        //线程的启动

        rab.start(); //不能调用run方法
        tor.start();

        for (int i = 0; i < 100; i++){
            System.out.println("-------"+i);
        }
    }
}
