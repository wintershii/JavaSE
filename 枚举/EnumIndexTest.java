package com.enu;

public class EnumIndexTest {
    enum Constants2{
        Constants_A,Constants_B
    }

    public static void main(String[] args) {
        for(int i = 0; i < Constants2.values().length; i++){
            System.out.println(Constants2.values()[i]+"在枚举类型中的位置索引值"+Constants2.values()[i].ordinal());
        }
    }
}
