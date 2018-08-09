package com.service;

import com.dao.ManageDao;
import com.dao.TeacherDao;
import com.model.Student;

import java.util.List;
import java.util.Scanner;

import static com.app.TeacherScreen.teacherScreen;
import static com.dao.Input.pwdInput;
import static com.dao.Input.userInput;

public class TeacherOperate {
    TeacherDao td = new TeacherDao();
    static String TEACHID;

    public void logIn() {
        String teachId = userInput();
        String pwd = pwdInput();
        boolean flag = td.teacherLogIn(teachId, pwd);
        if (flag){
            System.out.println("--------登陆成功！--------");
            TEACHID = teachId;
            teacherScreen();
        }else {
            System.out.println("---账号或密码错误!");
        }
    }

    public void inputGrade(){
        if (td.isEmpty()){
            td.initStuGrade();
        }
        String subject = td.searchSubject(TEACHID);
        List<Student> list = new ManageDao().printAllStudentDao("*");
        td.inputGradeDao(subject,list);
        td.updateGrade();
    }

    public void alterGrade(){
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入要修改成绩的学生的学号");
        String userId = scan.nextLine();
        td.alterGradeDao(userId);
        td.updateGrade();
    }

    public void searchStudent(){
        System.out.print("请输入要查找的学生的学号:");
        Scanner scan = new Scanner(System.in);
        String userId = scan.nextLine();
        td.searchStudentDao(userId);
    }

    public void gradeSort(){
        td.gradeSortDao(TEACHID);
    }
}
