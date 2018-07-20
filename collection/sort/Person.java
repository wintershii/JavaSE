package com.collection.sort;

public class Person {
    private final String name;
    private final int handsome;

    public Person() {
        this.name = null;
        this.handsome = 0;
    }

    public Person(String name, int handsome) {
        this.name = name;
        this.handsome = handsome;
    }

    public String getName() {
        return name;
    }

    public int getHandsome() {
        return handsome;
    }



    public String toString(){
        return "姓名:"+this.name+"帅气指数:"+this.handsome;
    }
}
