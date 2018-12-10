package com.collection;

//按价格排序
public class GoodsPriceCmp implements java.util.Comparator<Goods>{

    @Override
    public int compare(Goods o1, Goods o2) {
        return -(o1.getPrice()-o2.getPrice() > 0 ? 1 : (o1.getPrice() == o2.getPrice()) ? 0 : -1);
    }
}
