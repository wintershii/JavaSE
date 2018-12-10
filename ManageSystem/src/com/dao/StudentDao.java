package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *  学生端操作的DAO层
 */
public class StudentDao {
    /**
     * 登陆操作，根据输入的账号密码在数据库中一一判断是否对应，并返回结果
     * @param user
     * @param pwd
     * @return
     */
    public boolean logInDao(String user, String pwd){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement("select userId,pwd from stuifo");
            rs = ps.executeQuery();
            while (rs.next()){
                String userId = rs.getString("userId");
                String realPwd = rs.getString("pwd");
                if (user.equals(userId) && pwd.equals(realPwd)){
                    return true;
                }
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 先根据学生学号，在学生信息表中获取其专业与班级信息
     * 再在成绩信息表中获取总分的排名信息
     * 将排名信息根据 对应专业和班级筛选，最终打印
     * @param userId
     */
    public void classSortDao(String userId){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String major = null;
            Integer classroom = null;
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement("select major,classroom from stuifo where userId = ?");
            ps.setString(1,userId);
            rs = ps.executeQuery();
            while (rs.next()){
                major = rs.getString("major");
                classroom = rs.getInt("classroom");

                String user = null;
                Integer sum = null;

                ps = conn.prepareStatement("select userId,gSum from stugrade order by gSum desc ");

                ResultSet rs2 = ps.executeQuery();
                System.out.println("---" + major + " " + classroom + "班 总排名---");
                int i = 1;
                while (rs2.next()){
                    user = rs2.getString("userId");
                    sum = rs2.getInt("gSum");
                    String name = null;
                    Integer serial = null;
                    ps = conn.prepareStatement("select stuName,serial from stuifo where userId = ? and major" +
                            " = ? and classroom = ?");
                    ps.setString(1,user);
                    ps.setString(2,major);
                    ps.setInt(3,classroom);
                    ResultSet rs3 = ps.executeQuery();
                    while (rs3.next()){
                        name = rs3.getString("stuName");
                        serial = rs3.getInt("serial");
                        System.out.println("-----第" + i++ + "名-----");
                        System.out.println(name + " " + "班内序号:" + serial + "号" + "总分: " + sum + "分");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
