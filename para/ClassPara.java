package para;

public class ClassPara {
    public static void main(String[] args) {
        Person p = new Person("张三");
        change(p);
        System.out.println(p.getName());
    }

    public static void change(Person p){
        p.setName("李四");
    }
}

class Person{
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
