package com.collection;

public class GoodsFavCmp implements java.util.Comparator<Goods>{
    @Override
    public int compare(Goods o1, Goods o2) {
        return o1.getFav() - o2.getFav();
    }
}
