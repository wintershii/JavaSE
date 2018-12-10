package com.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1.binarySearch(List</? extends Comparable</? super T> list, T key)
 * 2.sort(List</?> list);
 *      sort(List</?> list , Comparator</? super T> c)
 * 3.reverse(List</?> list)     //翻转
 *4.shuffle(List</?> list)      //打乱顺序
 *5.swap(Lis</?> list,int i, int j)
 */
public class collectionsDeom1 {

    public static void main(String[] args) {
        //模拟斗地主洗牌
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 54; i++){
            list.add(i);
        }
        Collections.shuffle(list);
        List<Integer> p1 = new ArrayList<>();
        List<Integer> p2 = new ArrayList<>();
        List<Integer> p3 = new ArrayList<>();
        List<Integer> last = new ArrayList<>();
        for (int i = 0; i < 51 ; i += 3){
            p1.add(list.get(i));
            p2.add(list.get(i+1));
            p3.add(list.get(i+2));
        }
        last.add(list.get(51));
        last.add(list.get(52));
        last.add(list.get(53));

        System.out.println("第一个人："+ p1);
        System.out.println("第二个人："+ p2);
        System.out.println("第三个人："+ p3);
        System.out.println("底牌："+last);

    }


    public static void test1(){
        //reverse
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
    }
}
