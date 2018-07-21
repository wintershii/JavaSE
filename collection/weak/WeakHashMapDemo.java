package com.collection.weak;

import java.util.WeakHashMap;

public class WeakHashMapDemo {
    public static void main(String[] args) {
        WeakHashMap<String,String> map = new WeakHashMap<>();
        //常量池对象，不会回收
        map.put("abc","a");
        map.put("d","test");
        //gc 回收
        map.put(new String ("shi"),"c");
        map.put(new String("zs"),"s");

        System.out.println(map);

        System.gc();
        System.runFinalization();

        System.out.println(map);
    }
}
