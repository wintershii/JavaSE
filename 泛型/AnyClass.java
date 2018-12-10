package fanxing;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class AnyClass {
    public static void main(String[] args){
        //定义ArrayList容器,设置容器内的值类型为Integer
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(1);
        Map<Integer,String> m = new HashMap<Integer, String>();
        for(int i = 0; i < 5; i++){
            m.put(i,"成员" + i);
        }
        for(int i = 0; i < a.size(); i++){
            System.out.println("获取ArrayList容器的值" + a.get(i));
        }
        for(int i = 0; i < m.size(); i++){
            System.out.println("获取Map容器的值" + m.get(i));
        }
        //定义vector容器,使容器中的内容为String型
        Vector<String> v = new Vector<String>();
        for(int i = 0; i < 5; i++){
            v.addElement("成员" + i);
        }
        for(int i = 0; i < v.size(); i++){
            //显示容器中的内容
            System.out.println("获取Veactor容器的值" + v.get(i));
        }
    }
}
