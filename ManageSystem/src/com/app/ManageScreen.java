package com.app;

import java.util.Scanner;

public class ManageScreen {
    public static void manageScreen(){
        System.out.println("----------------管理员界面----------------");
        System.out.println("----------------1.新增管理员----------------");
        System.out.println("----------------2.新增教师----------------");
        System.out.println("----------------3.删除教师--------------");
        System.out.println("----------------4.修改教师信息----------------");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        switch (choice){
            case 1:
                System.out.println(1);
                break;
            case 2:
                System.out.println(2);
                break;
            case 3:
                System.out.println(3);
                break;
            case 4:
                System.out.println(4);
                break;
        }

    }
}
