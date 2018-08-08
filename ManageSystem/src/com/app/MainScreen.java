package com.app;

import java.util.Scanner;

import static com.service.ManageOperate.*;

public class MainScreen {
    public static void main(String[] args) {
        int choice = -1;
        while (choice != 0) {
            System.out.println("-------------学生信息管理系统-------------");
            System.out.println("----------------1.学生登陆----------------");
            System.out.println("----------------2.教师登陆----------------");
            System.out.println("----------------3.管理员登陆--------------");
            System.out.println("----------------4.修改密码----------------");
            System.out.println("----------------0.修改密码----------------");
            Scanner scan = new Scanner(System.in);
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(1);
                    break;
                case 2:
                    System.out.println(2);
                    break;
                case 3:
                    logIn();
                    break;
                case 4:
                    System.out.println(4);
                    break;
                case 0:
                    System.exit(0);
            }
        }

    }
}
