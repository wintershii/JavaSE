package com.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SleepDemo {

    public static void main(String[] args) throws InterruptedException {

        Date time = new Date(System.currentTimeMillis()+10*1000);
        long end = time.getTime();
        while(true){
            System.out.println(new SimpleDateFormat("mm:ss").format(time));
            time = new Date(time.getTime() - 1000);
            Thread.sleep(1000);
            if (end - 10000 > time.getTime()){
                break;
            }
        }

//        int num = 10;
//        while (true){
//            System.out.println(num--);
//            Thread.sleep(1000);
//            if(num <= 0){
//                break;
//            }
        }
    }
