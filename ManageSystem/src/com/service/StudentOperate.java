package com.service;

import com.dao.StudentDao;
import com.dao.TeacherDao;

import static com.app.StudentScreen.studentScreen;
import static com.dao.Input.pwdInput;
import static com.dao.Input.userInput;

/**
 *  学生操作的service层
 */
public class StudentOperate {
    StudentDao sd = new StudentDao();
    static String USER = null;//学生学号的全局变量

    /**
     * 学生登陆判断
     */
    public void logIn(){
        String user = userInput();
        String pwd = pwdInput();
        boolean flag = sd.logInDao(user,pwd);
        if (flag){
            System.out.println("-----登陆成功-----");
            USER = user;//登陆成功后，这个实例对象中的USER就变成了本次登陆的学生的学号
            studentScreen();
        }else {
            System.out.println("登陆失败，请检查账号密码");
        }
    }

    /**
     * 搜索该学号的学生的信息
     */
    public void searchInfo(){
        new TeacherDao().searchStuDao(USER);
    }

    /**
     * 搜索该学号的学生的成绩
     */
    public void searchGrade(){
        new TeacherDao().searchGraDao(USER);
    }

    /**
     * 该学生的班内成绩排名
     */
    public void classSort(){
        sd.classSortDao(USER);
    }

}
