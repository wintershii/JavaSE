package cn.pra_01.collection_;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *  This program sorts a set of item by comparing their descriptions
 */
public class TreeSetTest {
    public static void main(String[] args) {
        SortedSet<Item> parts = new TreeSet<>();
        parts.add(new Item("shi",1234));
        parts.add(new Item("zhang",9912));
        parts.add(new Item("hao",7777));

        System.out.println(parts);

        NavigableSet<Item> sortByDescription = new TreeSet<>(
                Comparator.comparing(Item::getDescription));

        sortByDescription.addAll(parts);
        System.out.println(sortByDescription);
    }
}
