package com.app;

import com.dao.ChangePwd;
import com.service.ManageOperate;
import com.service.StudentOperate;
import com.service.TeacherOperate;

import java.util.Scanner;

/**
 *  程序主界面，实例化service层的类，进入登陆界面
 */

public class MainScreen {
    public static void main(String[] args) {
        ManageOperate mo = new ManageOperate();
        TeacherOperate to = new TeacherOperate();
        StudentOperate so = new StudentOperate();
        ChangePwd cp = new ChangePwd();
        int choice = -1;
        while (choice != 0) {
            System.out.println("-------------学生信息管理系统-------------");
            System.out.println("----------------1.学生登陆----------------");
            System.out.println("----------------2.教师登陆----------------");
            System.out.println("----------------3.管理员登陆--------------");
            System.out.println("----------------4.修改密码----------------");
            System.out.println("----------------0.--退出------------------");
            Scanner scan = new Scanner(System.in);
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    so.logIn();
                    break;
                case 2:
                    to.logIn();
                    break;
                case 3:
                    mo.logIn();
                    break;
                case 4:
                    cp.changePwd();
                    break;
                case 0:
                    break;
            }
        }

    }
}
