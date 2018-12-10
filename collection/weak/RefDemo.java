package com.collection.weak;

import java.lang.ref.WeakReference;

public class RefDemo {


    public static void main(String[] args) {

        test01();
        test02();
    }
        //弱引用，只要运行垃圾回收机制就会被回收
    public static void test01(){
        //字符串常量池，共享(不能回收)
        String str = "shi dong xuan";
        //弱引用管理对象
        WeakReference<String> wr = new WeakReference<String>(str);
        System.out.println("gc运行前:"+wr.get());
        //断开引用
        str = null;
        //通知回收
        System.gc();
        System.runFinalization();
        System.out.println("gc运行后:"+wr.get());
    }

    public static void test02(){
        //字符串对象在堆中,不共享
        String str = new String("shi dong xuan");
        //弱引用管理对象
        WeakReference<String> wr = new WeakReference<String>(str);
        System.out.println("gc运行前:"+wr.get());
        //断开引用
        str = null;
        //通知回收
        System.gc();
        System.runFinalization();
        System.out.println("gc运行后:"+wr.get());
    }

}
