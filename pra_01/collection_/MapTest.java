package cn.pra_01.collection_;

import com.collection.Employee;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<String,Employe> staff= new HashMap<>();
        staff.put("123",new Employe("shi"));
        staff.put("345",new Employe("zhang"));
        staff.put("678",new Employe("hao"));
        staff.put("999",new Employe("zeng"));
        staff.put("000",new Employe("meng"));
        System.out.println(staff);

        staff.remove("345");

        staff.put("000",new Employe("sun"));

        System.out.println(staff.get("123"));

        staff.forEach((k,v) ->
                System.out.println("key=" + k + ", value=" + v));
    }
}

class Employe {
    private String name;

    public Employe(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString(){
        return name;
    }
}