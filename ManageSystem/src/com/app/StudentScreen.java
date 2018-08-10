package com.app;

import com.service.StudentOperate;

import java.util.Scanner;

/**
 * 学生端主界面
 */

public class StudentScreen {
    public static void studentScreen(){
        StudentOperate so = new StudentOperate();
        int choice = -1;
        while (choice != 0) {
            System.out.println("------------------学生界面----------------");
            System.out.println("----------------1.查询个人信息----------------");
            System.out.println("----------------2.查询成绩信息----------------");
            System.out.println("----------------3.查看班内排名----------------");
            System.out.println("----------------0.--退出----------------------");
            Scanner scan = new Scanner(System.in);
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    so.searchInfo();
                    break;
                case 2:
                    so.searchGrade();
                    break;
                case 3:
                    so.classSort();
                    break;
                case 0:
                    return;
            }
        }
    }
}
