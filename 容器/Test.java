import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

public class Test {
    public static void main(String[] args){
        Collection<String>list = new ArrayList<>();     //实例化集合类对象
        list.add("a");                                  //向集合添加元素
        list.add("b");
        list.add("c");
        Iterator<String>it = list.iterator();               //创建迭代器
        while(it.hasNext()){                               //判断是否有下一个元素
            String str = (String)it.next();                 //获取集合中元素
            System.out.println(str);
        }
    }
}
