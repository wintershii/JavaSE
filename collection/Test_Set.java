package com.collection;

import java.util.HashMap;

/**
 * 自定义自己的HashSet
 *
 */

public class Test_Set {
    HashMap map;
    private static final Object PRESENT = new Object();

    public int getSize(){
        return map.size();
    }

    public Test_Set(){
        map = new HashMap();
    }

    public void add(Object o){
        map.put(o,PRESENT);         //Set的不可重复 就是利用了map里面键对象的不可重复
    }

    public static void main(String[] args) {
        Test_Set s = new Test_Set();
        s.add("aaa");
        s.add(new String("bbb"));
        System.out.println(s.getSize());
    }
}
