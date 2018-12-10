import sun.reflect.generics.tree.Tree;

import java.util.*;

public class Test_03 {
    public static void main(String[] args) {
        Set<Person> set = new TreeSet<>((o1, o2) -> o1.getName().compareTo(o2.getName()));

        set.add(new Person(23,"shi"));
        set.add(new Person(10,"zhang"));
        set.add(new Person(57,"adv"));
        set.add(new Person(99,"hao"));
        set.add(new Person(36,"meng"));

        Iterator<Person> iter = set.iterator();
        while (iter.hasNext()){
            Person p = iter.next();
            System.out.println("age=" + p.getAge() + "name=" + p.getName());
        }
    }
}

class Person {
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}