package anno;

@MyTable("tb_student")
public class MyStudent {

    @MyField(columnName = "id",type = "int",length = 10)
    private int id;
    @MyField(columnName = "sname",type = "varchar" ,length = 10)
    private String name;
    @MyField(columnName = "age",type = "int",length = 3)
    private int age;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
