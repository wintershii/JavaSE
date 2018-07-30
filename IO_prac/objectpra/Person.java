package IO_prac.objectpra;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private int age;
    private transient String intro;

    public Person(String name, int age, String intro) {
        this.name = name;
        this.age = age;
        this.intro = intro;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getIntro() {
        return intro;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String toString(){
        return name + " " + age + " " + intro;
    }
}
