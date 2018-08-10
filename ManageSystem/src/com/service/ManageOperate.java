package com.service;

import com.dao.JDBCUtil;
import com.dao.ManageDao;
import com.dao.TeacherDao;
import com.model.Student;
import com.model.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import static com.app.ManageScreen.manageScreen;
import static com.dao.Input.*;

/**
 * 管理员service层操作
 */
public class ManageOperate {
    //实例化DAO层的类之后调用方法
    ManageDao md = new ManageDao();
    /**
     *  管理员登陆时调用，若数据库中管理员表为空，则调用新增管理员方法，否则进行登陆
     */
    public  void logIn() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement("select count(*) from mangeinfo");
            rs = ps.executeQuery();
            Integer count = null;
            if (rs.next()) {
                 count = rs.getInt(1);
            }
            if (count == 0) {
                newManager();
                String user = userInput();
                String pwd = pwdInput();
                logIn(user, pwd);
            } else {
                String user = userInput();
                String pwd = pwdInput();
                logIn(user, pwd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("sql语句输入错误");
            JDBCUtil.close(rs, ps, conn);
        }
    }

    /**
     *  重写登陆方法，利用键盘输入的值进行登陆
     *  从数据库中读入数据，
     * @param manageId
     * @param pwd
     */

    public  void logIn(String manageId, String pwd) {
        boolean flag = md.manageLogIn(manageId, pwd);
        if (flag){
            System.out.println("--------登陆成功！--------");
            manageScreen();
        }else {
            System.out.println("---账号或密码错误!");
        }
    }

    /**
     * 新增管理员，第一次进入系统时(管理员表为空时)可以设置，之后也可以在管理员界面添加
     */
    public  void newManager() {
        Scanner scan = new Scanner(System.in);
        System.out.println("---请输入你的用户名(必须是4位)：");
        String manageId = scan.nextLine();
        System.out.println("---请输入你的密码：");
        String pwd = scan.nextLine();
        System.out.println("---请输入你的姓名：");
        String manageName = scan.nextLine();
        System.out.println("---请输入你的手机号：");
        String phone = scan.nextLine();

        boolean flag = md.newManagerDao(manageId,pwd,manageName,phone);
        if (flag){
            System.out.println("注册成功！");
        }else {
            System.out.println("注册失败！用户名已存在！");
        }
    }

    /**
     * 新增教师信息
     */
    public  void newTeacher(){
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入教师用户名(必须是8位):");
        String teachId = scan.nextLine();
        System.out.println("请输入教师密码:");
        String pwd = scan.nextLine();
        System.out.println("请输入教师姓名:");
        String teachName = scan.nextLine();
        System.out.println("请输入教师手机号:");
        String phone = scan.nextLine();
        System.out.println("请输入教师专业:");
        String teachMajor = scan.nextLine();
        System.out.println("请输入教师的科目:");
        String subject = scan.nextLine();
        boolean flag = md.newTeacherDao(teachId,pwd,teachName,phone,teachMajor,subject);
        if (flag){
            System.out.println("新增教师成功！");
        }else {
            System.out.println("教师用户名重复!");
        }

    }

    /**
     * 删除教师信息
     */
    public  void deleteTeacher(){
        System.out.println("请输入要删除的教师的用户名");
        Scanner scan = new Scanner(System.in);
        String teachId = scan.nextLine();

        boolean flag = md.deleteTeacherDao(teachId);
        if (flag){
            System.out.println("删除成功！");
        }else {
            System.out.println("删除失败！请检查教师用户名");
        }
    }

    /**
     * 对教师信息进行修改
     */
    public  void alterTeacher(){
        System.out.println("请输入教师用户名");
        Scanner scan = new Scanner(System.in);
        String teachId = scan.nextLine();
        printTeacher(teachId);
        System.out.println("请选择要修改该教师的哪一条信息");
        System.out.print("1.密码" + "  ");
        System.out.print("2.姓名" + "  ");
        System.out.print("3.手机号" + "  ");
        System.out.print("4.专业" + "  ");
        System.out.print("5.科目" + "  ");
        System.out.println("0.取消" + "  ");
        int choice = -1;
        choice = scan.nextInt();
        System.out.println("您要将其修改为:");
        scan.nextLine();
        String newInfo = scan.nextLine();
        boolean flag = false;
        switch(choice){
            case 1:flag = md.alterTeacherDao(teachId,"pwd",newInfo);
                break;
            case 2:flag = md.alterTeacherDao(teachId,"teachName",newInfo);
                break;
            case 3:flag = md.alterTeacherDao(teachId,"phone",newInfo);
                break;
            case 4:flag = md.alterTeacherDao(teachId,"major",newInfo);
                break;
            case  5:flag = md.alterTeacherDao(teachId,"subject",newInfo);
                break;
            case 0:
                break;
        }
        if (flag){
            System.out.println("修改成功！");
        }else {
            System.out.println("修改失败！");
        }
    }

    /**
     * 打印指定教师信息，参数为教师的用户名
     * @param teachId
     */
    public void printTeacher(String teachId){
        Teacher teach = md.printTeacherDao(teachId);
        System.out.print("教师用户名：" + teach.getUser() + "     ");
        System.out.println("教师密码：" + teach.getPwd());
        System.out.print("教师姓名：" + teach.getName() + "     ");
        System.out.println("教师手机号：" + teach.getPhone());
        System.out.print("教师专业：" + teach.getMajor() + "     ");
        System.out.println("教师科目：" + teach.getSubject());
    }

    /**
     * 打印处所有教师的信息
     */
    public void printAllTeacher(){
        List<String> list = md.printAllTeacherDao();
        Iterator it = list.iterator();
        int i = 1;
        while (it.hasNext()){
            System.out.println("-----第" + i++ + "名教师-----");
            printTeacher((String) it.next());
        }
    }

    /**
     * 新增学生信息
     */
    public void newStudent(){
        Scanner scan = new Scanner(System.in);
        System.out.print("请输入学生学号：");
        String user = scan.nextLine();
        String pwd = "000000";
        System.out.print("请输入学生姓名：");
        String name = scan.nextLine();
        System.out.print("请输入学生手机号：");
        String phone = scan.nextLine();
        System.out.print("请输入学生专业：");
        String major = scan.nextLine();
        System.out.print("请输入学生班级：");
        String classroom = scan.nextLine();
        System.out.print("请输入学生班内序号：");
        Scanner scan1 = new Scanner(System.in);
        Integer serial = scan1.nextInt();
        Date entranceTime = new Date(System.currentTimeMillis());
        boolean flag = md.newStudentDao(user,pwd,name,phone,major,classroom,serial,entranceTime);
        if (flag){
            System.out.println("新增学生成功！");
        }else {
            System.out.println("新增学生失败");
        }
        new TeacherDao().initStuGrade();
    }

    /**
     * 删除学生信息
     */
    public void deleteStudent(){
        System.out.print("请输入要删除的学生学号:");
        Scanner scan = new Scanner(System.in);
        String user = scan.nextLine();
        boolean flag = md.deleteStudentDao(user);
        if (flag){
            System.out.println("删除成功！");
        }else {
            System.out.println("删除失败!");
        }
    }

    /**
     * 打印出所有学生的信息
     */
    public void printAllStudent(){
        System.out.println("请选择要打印的专业:");
        System.out.println("1.计算机科学");
        System.out.println("2.软件工程");
        System.out.println("3.网络工程");
        System.out.println("4.全部");
        int choice = -1;
        Scanner scan = new Scanner(System.in);
        choice = scan.nextInt();
        String major = null;
        switch(choice){
            case 1:major = "计算机科学";break;
            case 2:major = "软件工程";break;
            case 3:major = "网络工程";break;
            case 4:major = "*"; break;
        }
        List<Student> list = md.printAllStudentDao(major);
        Iterator it = list.iterator();
        int i = 1;
        while (it.hasNext()){
            System.out.println("-----第" + i++ +"名学生-----");
            Student stu = (Student) it.next();
            System.out.print("学号：" + stu.getUser() + "   ");
            System.out.println("密码：" + stu.getPwd());
            System.out.print("姓名：" + stu.getName() + "   ");
            System.out.println("手机号:" + stu.getPhone());
            System.out.print("专业：" + stu.getMajor() + "   ");
            System.out.println("班级:"+ stu.getClassroom() + "  班内序号:" + stu.getSerial());
        }
    }
}
