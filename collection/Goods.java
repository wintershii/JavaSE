package com.collection;

public class Goods {
    private String name;
    private int price;
    private int fav;

    public Goods() {
    }

    public Goods(String name, int price, int fav) {
        this.name = name;
        this.price = price;
        this.fav = fav;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getFav() {
        return fav;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setFav(int fav) {
        this.fav = fav;
    }

    public String toString(){
        return "商品名："+name+"收藏量："+this.fav+"价格："+this.price+"\n";
    }
}
