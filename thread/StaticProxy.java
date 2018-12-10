package com.thread;

import java.lang.ref.WeakReference;

/**
 * 静态代理 设计模式
 * 1. 真实角色
 * 2. 代理角色 : 要持有真是角色的引用
 * 3。 二者公共的接口
 */

public class  StaticProxy {

    public static void main(String[] args) {
        //创建真实角色
        You you = new You();
        //创建代理角色 + 真实角色的引用
        WeddingCompany wed = new WeddingCompany(you);
        //执行
        wed.marry();
    }

}

interface Marry{
    public abstract void marry();
}
// 真实角色
class You implements Marry{
    @Override
    public void marry() {
        System.out.println("你和李冰冰结婚了...");
    }
}

class WeddingCompany implements Marry{
    private Marry you;

    public WeddingCompany() {
    }

    public WeddingCompany(Marry you) {
        this.you = you;
    }

    public void before(){
        System.out.println("布置猪窝...");
    }

    public void after(){
        System.out.println("滚猪窝...");
    }
    @Override
    public void marry() {
        before();
        you.marry();
        after();

    }
}
