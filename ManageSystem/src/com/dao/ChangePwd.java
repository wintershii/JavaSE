package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ChangePwd {
    /**
     * 修改密码选择界面
     */
    public void changePwd(){
        System.out.println("-----请选择你的身份-----");
        System.out.println("-----1.   学生    ------");
        System.out.println("-----2.   教师    ------");
        System.out.println("-----3.   管理员  ------");
        int choice = -1;
        Scanner scan = new Scanner(System.in);
        choice = scan.nextInt();
        String identity = null;
        switch (choice){
            case 1: identity = "stuIfo";break;
            case 2: identity = "teachInfo";break;
            case 3: identity = "mangeInfo";break;
        }
        changePwd(identity);
    }

    /**
     * 实际修改密码界面，从控制台获取账号密码，并在数据库中一一判断是否对应，若对应则修改密码为新密码
     * @param identity
     */
    public void changePwd(String identity){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConnection();
            if (identity.equals("stuIfo")){
                ps = conn.prepareStatement("select userId,pwd from stuIfo");
            }else if (identity.equals("teachInfo")){
                ps = conn.prepareStatement("select teachId,pwd from teachInfo");
            }else {
                ps = conn.prepareStatement("select manageId,pwd from mangeInfo");
            }
            Scanner scan = new Scanner(System.in);
            System.out.print("请输入原账号:");
            String user = scan.nextLine();
            System.out.print("请输入原密码:");
            String pwd = scan.nextLine();
            rs = ps.executeQuery();
            while (rs.next()){
                String userId = rs.getString(1);
                String realPwd = rs.getString(2);
                if (user.equals(userId) && pwd.equals(realPwd)){
                    System.out.println("输入正确！现在请设置新密码");
                    String newPwd = scan.nextLine();

                    if (identity.equals("stuIfo")){
                        ps = conn.prepareStatement("update " + identity + " set pwd = ? where userId = ? ");
                    }else if (identity.equals("teachInfo")){
                        ps = conn.prepareStatement("update " + identity + " set pwd = ? where teachId = ? ");
                    }else {
                        ps = conn.prepareStatement("update " + identity + " set pwd = ? where manageId = ? ");
                    }
                    ps.setString(1,newPwd);
                    ps.setString(2,userId);
                    ps.executeUpdate();
                    System.out.println("修改密码成功！");
                    return;
                }
            }
            System.out.println("账号或密码错误!");
            return;

            } catch (SQLException e) {
                e.printStackTrace();
        }
    }
}
