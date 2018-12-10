package com.collection.sort;

import java.util.*;

public class TreeMapDemo {

    public static void main(String[] args) {
        Person p1 = new Person("你", 100);
        Person p2 = new Person("刘德华", 1000);
        Person p3 = new Person("张学友", 998);
        Person p4 = new Person("sb", 1);

        TreeMap<Person,String> map = new TreeMap<Person,String>(
                new java.util.Comparator<Person>() {
                    @Override
                    public int compare(Person o1, Person o2) {
                        return o1.getHandsome() - o2.getHandsome();
                    }
                });
        map.put(p1,"wom");
        map.put(p2,"won");
        map.put(p3,"wot");
        map.put(p4,"wou");


        Set<Map.Entry<Person,String>> set = map.entrySet();
        Iterator<Map.Entry<Person,String >> it = set.iterator();

        System.out.println(set.size());
        while(it.hasNext()){

            Map.Entry<Person,String> entry = it.next();
            Person tp = entry.getKey();
            String str = entry.getValue();

            System.out.println("人物信息："+tp+"备注"+str);
        }

    }

}
