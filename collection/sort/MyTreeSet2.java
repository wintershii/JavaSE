package com.collection.sort;

import java.util.TreeSet;

public class MyTreeSet2 {

    public static void main(String[] args) {

        Worker w1 = new Worker("垃圾回收员",12000);
        Worker w2 = new Worker("农民工",8000);
        Worker w3 = new Worker("程序员",5000);

        TreeSet<Worker> workers = new TreeSet<Worker>();

        workers.add(w1);
        workers.add(w2);
        workers.add(w3);

        System.out.println(workers);
    }
}
