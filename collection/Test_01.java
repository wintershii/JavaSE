package com.collection;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Test_01 {
    public static void main(String[] args) throws ParseException {
        Employee e = new Employee(0301,"shidongxuan",3000,"项目部","2007-10");
        Employee e2 = new Employee(0302,"zhangshuo",3001,"项目部","2007-11");
        Employee e3 = new Employee(0303,"haojianqiang",3002,"项目部","2007-12");

        List<Employee> list = new ArrayList<Employee>();

        list.add(e);
        list.add(e2);
        list.add(e3);
        printEmpName(list);
    }

    public static void printEmpName(List<Employee> list){
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i).getName());
        }
    }

}
