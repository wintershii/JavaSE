package com.app;

import com.service.TeacherOperate;

import java.util.Scanner;

/**
 *  教师端主界面
 */

public class TeacherScreen {
    public static void teacherScreen(){
        TeacherOperate to = new TeacherOperate();
        int choice = -1;
        while (choice != 0) {
            System.out.println("------------------教师界面----------------");
            System.out.println("----------------1.录入成绩信息----------------");
            System.out.println("----------------2.修改成绩信息----------------");
            System.out.println("----------------3.查找学生信息----------------");
            System.out.println("----------------4.本科目学生成绩排名----------");
            System.out.println("----------------0.--退出----------------------");
            Scanner scan = new Scanner(System.in);
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    to.inputGrade();
                    break;
                case 2:
                    to.alterGrade();
                    break;
                case 3:
                    to.searchStudent();
                    break;
                case 4:
                    to.gradeSort();
                    break;
                case 0:
                    return;
            }
        }
    }
}
