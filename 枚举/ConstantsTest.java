package com.enu;

interface Constants{
    public static final int Constants_A = 1;
    public static final int Constants_B = 12;
}

public class ConstantsTest {
    enum Constants2{
        CONSTANTS_A,CONSTANTS_B
    }
    public static void doit(int c){
        switch (c){
            case Constants.Constants_A:
                System.out.println("doit()Constants_A");
                break;
            case Constants.Constants_B:
                System.out.println("doit()Constants_B");
                break;
        }
    }

    public static void doit2(Constants2 c){
        switch (c){
            case CONSTANTS_A:
                System.out.println("doit2()Constants_A");
                break;
            case CONSTANTS_B:
                System.out.println("doit2()Constants_B");
                break;
        }
    }

    public static void main(String[] args){
        ConstantsTest.doit(Constants.Constants_A);
        ConstantsTest.doit2(Constants2.CONSTANTS_A);
        ConstantsTest.doit2(Constants2.CONSTANTS_B);
        ConstantsTest.doit(3);
        //ConstantsTest.doit2(3);
    }
}
