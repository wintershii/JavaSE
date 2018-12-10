package com.app;

import com.service.ManageOperate;

import java.util.Scanner;

/**
 *  管理员主界面，选择要进行的操作
 */
public class ManageScreen {
    public static void manageScreen(){
        ManageOperate mo = new ManageOperate();
        int choice = -1;
        while (choice != 0) {
            System.out.println("-----------------管理员界面----------------");
            System.out.println("----------------1.新增管理员---------------");
            System.out.println("----------------2.新增教师信息-------------");
            System.out.println("----------------3.删除教师信息-------------");
            System.out.println("----------------4.新增学生信息-------------");
            System.out.println("----------------5.删除学生信息-------------");
            System.out.println("----------------6.修改教师信息-------------");
            System.out.println("----------------7.打印教师信息-------------");
            System.out.println("----------------8.打印学生信息-------------");
            System.out.println("----------------0.--退出-------------------");
            Scanner scan = new Scanner(System.in);
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    mo.newManager();
                    break;
                case 2:
                    mo.newTeacher();
                    break;
                case 3:
                    mo.deleteTeacher();
                    break;
                case 4:
                    mo.newStudent();
                    break;
                case 5:
                    mo.deleteStudent();
                    break;
                case 6:
                    mo.alterTeacher();
                    break;
                case 7:
                    mo.printAllTeacher();
                    break;
                case 8:
                    mo.printAllStudent();
                    break;
                case 0:
                    return;
            }
        }
    }
}
