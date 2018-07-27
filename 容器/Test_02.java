import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test_02 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("shi");
        list.add("zhang");
        list.add("hao");
        list.add("du");
        list.add("abv");

        //list.sort((o1, o2) -> o1.length() - o2.length());
        Collections.sort(list,(o1, o2) -> o1.length() - o2.length());

        System.out.println(list);
    }
}

