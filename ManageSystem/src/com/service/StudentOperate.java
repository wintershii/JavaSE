package com.service;

import com.dao.StudentDao;
import com.dao.TeacherDao;

import static com.app.StudentScreen.studentScreen;
import static com.dao.Input.pwdInput;
import static com.dao.Input.userInput;

public class StudentOperate {
    StudentDao sd = new StudentDao();
    static String USER = null;
    public void logIn(){
        String user = userInput();
        String pwd = pwdInput();
        boolean flag = sd.logInDao(user,pwd);
        if (flag){
            System.out.println("-----登陆成功-----");
            USER = user;
            studentScreen();
        }else {
            System.out.println("登陆失败，请检查账号密码");
        }
    }

    public void searchInfo(){
        new TeacherDao().searchStuDao(USER);
    }

    public void searchGrade(){
        new TeacherDao().searchGraDao(USER);
    }

    public void classSort(){
        sd.classSortDao(USER);
    }

}
