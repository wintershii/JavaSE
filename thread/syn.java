package com.thread;

/**
 *  同步：并发  多个线程访问同一份资源 确保资源安全 --->线程安全
 *  实现：synchronize  :加锁
 *    1. 同步块
 *       synchronized( 引用类型 | 类.class){}
 *    2.同步方法
 *  线程安全 ：StirngBuffer,
 *
 *
 * 单例设计模式  确保一个类只有一个对象（外部使时）
 */

public class syn {
    public static void main(String[] args) {
        jvmThread j = new jvmThread(100);
        jvmThread j2 = new jvmThread(500);

        j.start();
        j2.start();
    }
}

/**
 *  懒汉式  double checking
 *    1.构造器私有化，避免外部直接创建对象
 *    2.声明一个静态变量    (饿汉式同时创建该对象)
 *    3.创建一个对外的公共静态方法 访问该变量  如果变量没有对象 创建该对象。
 */
class jvm{
    private static jvm instance = null;
    //构造器私有化,避免外部直接创建对象
    private jvm(){

    }

    public static  jvm getInstance(long time) {
        if (null == instance) {                                    //效率更高
            synchronized (jvm.class) {
                if (null == instance) {                                //double checking
                    try {
                        Thread.sleep(time);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new jvm();
                }
            }
        }
        return instance;
    }

    public static synchronized jvm getInstance1(long time){
        if(null == instance){
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new jvm();
        }
        return instance;
    }

}


class jvmThread extends Thread{
    private long time;

    public jvmThread() {
    }

    public jvmThread(long time) {
        this.time = time;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"-->创建"+jvm.getInstance(time));
    }
}