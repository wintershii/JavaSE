package com.thread;

/**
 * 过多的同步方法可能会造成死锁
 * 解决方案：生产者 消费者模式  (不是设计模式，是多线程中解决死锁的一个方案)
 *
 * wait()等待  会释放锁
 */

public class synDemo03 {

    public static void main(String[] args) {
        Object goods = new Object();
        Object money = new Object();

        Test t1 = new Test(goods,money);
        Test2 t2 = new Test2(goods,money);
            Thread p1 = new Thread(t1);
            Thread p2 = new Thread(t2);
            p1.start();
            p2.start();
    }
}

class Test implements Runnable{
    Object goods;
    Object money;

    public Test(Object goods, Object money) {
        this.goods = goods;
        this.money = money;
    }

    @Override
    public void run() {
        while (true){
            test();
        }
    }

    public void test(){
        synchronized (goods){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (money){

            }
        }
        System.out.println("一手给钱");
    }
}

class Test2 implements Runnable{
    Object goods;
    Object money;

    public Test2(Object goods, Object money) {
        super();
        this.goods = goods;
        this.money = money;
    }

    @Override
    public void run() {
        while (true){
            test();
        }
    }

    public void test(){
        synchronized (money){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (goods){

            }
        }
        System.out.println("一手给货");
    }
}
