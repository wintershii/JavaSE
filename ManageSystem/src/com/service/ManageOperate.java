package com.service;

import com.dao.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.app.ManageScreen.manageScreen;

/**
 * 管理员操作
 */
public class ManageOperate {
    public static void logIn() {
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
                System.out.println(count);
            }

            if (count == 0) {
                newManager();
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

    public static void logIn(String manageId, String pwd) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement("select manageId,pwd from mangeInfo");
            rs = ps.executeQuery();
            String user = rs.getString("manageId");
            String realPwd = rs.getString("pwd");
            if (user.equals(manageId) && realPwd.equals(pwd)) {
                System.out.println("--------登陆成功！--------");
                manageScreen();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("sql语句输入错误");
            JDBCUtil.close(rs, ps, conn);
        }
    }

    public static String userInput() {
        Scanner scan = new Scanner(System.in);
        String user = scan.nextLine();
        return user;
    }

    public static String pwdInput() {
        Scanner scan = new Scanner(System.in);
        String pwd = scan.nextLine();
        return pwd;
    }

    public static void newManager() {
        Scanner scan = new Scanner(System.in);
        System.out.println("---请输入你的用户名：");
        String manageId = scan.nextLine();
        System.out.println("---请输入你的密码：");
        String pwd = scan.nextLine();
        System.out.println("---请输入你的姓名：");
        String manageName = scan.nextLine();
        System.out.println("---请输入你的手机号：");
        String phone = scan.nextLine();

        Connection conn = JDBCUtil.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("insert into mangeinfo (manageId" +
                    ",pwd,manageName,phone) values (?,?,?,?)");
            ps.setString(1, manageId);
            ps.setString(2, pwd);
            ps.setString(3, manageName);
            ps.setString(4, phone);
            ps.executeUpdate();
            System.out.println("注册成功！");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("注册失败！用户名已存在！");
        }

    }

}
