package com.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test_02 {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("id",0301);
        map.put("name","shidongxuan");
        map.put("salary",3050);
        map.put("hireDate","2007-10");


        List<Map> list = new ArrayList<Map>();

        list.add(map);
        print(list);
    }

    public static void print(List<Map> list){
        for(int i = 0; i < list.size(); i++){
            Map tempMap = list.get(i);
            System.out.println(tempMap.get("name"));
        }
    }
}
