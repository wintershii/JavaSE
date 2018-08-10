package com.service;

import com.dao.ManageDao;
import com.dao.TeacherDao;
import com.model.Student;

import java.util.List;
import java.util.Scanner;

import static com.app.TeacherScreen.teacherScreen;
import static com.dao.Input.pwdInput;
import static com.dao.Input.userInput;

/**
 * 教师操作的service层
 */
public class TeacherOperate {
    TeacherDao td = new TeacherDao();
    static String TEACHID;//教师的用户名，静态变量

    /**
     * 登陆操作
     */
    public void logIn() {
        String teachId = userInput();
        String pwd = pwdInput();
        boolean flag = td.teacherLogIn(teachId, pwd);
        if (flag){
            System.out.println("--------登陆成功！--------");
            TEACHID = teachId;//登陆成功后获取该教师的用户名
            teacherScreen();
        }else {
            System.out.println("---账号或密码错误!");
        }
    }

    /**
     * 录入成绩
     */
    public void inputGrade(){
        if (td.isEmpty()){
            td.initStuGrade();
        }
        String subject = td.searchSubject(TEACHID);//获取教师的科目
        List<Student> list = new ManageDao().printAllStudentDao("*");//获取学生信息表
        td.inputGradeDao(subject,list);//对学生的该科目进行打分
        td.updateGrade();//更新成绩表
    }

    /**
     * 修改成绩
     */
    public void alterGrade(){
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入要修改成绩的学生的学号");
        String userId = scan.nextLine();
        td.alterGradeDao(userId);//对指定学号的学生的成绩进行修改
        td.updateGrade();//更新成绩
    }

    /**
     * 查找学生信息(基本信息+成绩信息)
     */
    public void searchStudent(){
        System.out.print("请输入要查找的学生的学号:");
        Scanner scan = new Scanner(System.in);
        String userId = scan.nextLine();
        td.searchStudentDao(userId);
    }

    /**
     * 该科目学生成绩的排名
     */
    public void gradeSort(){
        td.gradeSortDao(TEACHID);
    }
}
