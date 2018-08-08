package com.dao;

import java.sql.*;

public class JDBCUtil {
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/managesystem?useSSL=false&" +
                            "serverTimezone=GMT%2B8&characterEncoding=utf-8","root","990708");
            return conn;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Mysql导包失败");
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
            return null;
        }
    }


    public static void close(ResultSet rs, Statement ps, Connection conn){
        try {
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Statement ps, Connection conn){
        try {
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Connection conn){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
