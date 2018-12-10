package cn.pra_01.collection_;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 *This program demonstrates operations on linked lists
 */
public class LinkedList_Test {
    public static void main(String[] args) {
        List<String> a = new LinkedList<>();
        a.add("shi");
        a.add("zhang");
        a.add("hao");

        List<String> b = new LinkedList<>();
        b.add("zeng");
        b.add("meng");
        b.add("sun");
        b.add("du");

        //merge the word from b into a

        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();

        while(bIter.hasNext()){
            if (aIter.hasNext()){
                aIter.next();
            }
            aIter.add(bIter.next());
        }
        System.out.println(a);

        //remove every second word from b

        bIter = b.iterator();
        while (bIter.hasNext()){
            bIter.next();   //skip one element
            if (bIter.hasNext()){
                bIter.next();   //skip next element
                bIter.remove(); //remove that element
            }
        }
        System.out.println(b);

        //bulk operation: remove all words in b from a

        a.removeAll(b);
        System.out.println(a);
    }
}
