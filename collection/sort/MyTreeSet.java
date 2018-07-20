package com.collection.sort;

import java.util.TreeSet;

public class MyTreeSet {
    public static void main(String[] args) {
        Person p1 = new Person("你",100);
        Person p2 = new Person("刘德华",1000);
        Person p3 = new Person("张学友",998);
        Person p4 = new Person("sb",1);

        //在添加数据时排序，数据不会影响原来的顺序
        //TreeSet不能修改数据
        TreeSet<Person> persons = new TreeSet<Person>(
                    new java.util.Comparator<Person>() {
                        @Override
                        public int compare(Person o1, Person o2) {
                            return o1.getHandsome() - o2.getHandsome();
                        }             //匿名内部类
                    }
        );
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        persons.add(p4);

        System.out.println(persons);
    }
}
