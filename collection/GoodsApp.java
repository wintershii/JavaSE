package com.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GoodsApp {

    public static void main(String[] args) {
        List<Goods> list = new ArrayList<Goods>();
        list.add(new Goods("zhangshuo",999,2001));
        list.add(new Goods("shidongxuan",1000,2000));

        list.add(new Goods("haojianqiang",998,2002));

        System.out.println("排序前：" + list);
        Collections.sort(list,new GoodsFavCmp());
        System.out.println("排序后:"+list);
    }
}
