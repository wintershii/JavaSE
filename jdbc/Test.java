package jdbc;

import java.io.IOException;
import java.sql.*;
import java.util.Date;

/**
 * 一组要么同时执行成功，要么同时执行失败的SQL语句。是数据库操作的一个执行单元
 *
 * 事务开始于：1.连接到数据库上 并执行一条DML语句(insert,update或delete) 2.前一个事务结束后，又输入额另外一条DML语句
 * 事务结束于：1.执行commit或rollback语句  2.执行一条DDL语句，如create table语句，这种情况下会自动执行commit语句
 *            3.执行一条DCL语句 如grant  4.断开与数据库的连接
 *            5. 执行一句DML语句 但这条语句却失败了  这种情况下 会为这个无效的DML语句执行rollback语句
 *
 * 测试事物的基本概念和用法
 * 同一事务内的操作要么同时成功要么同时失败、
 * 如果前面成功后面失败，就回滚到操作之前的状态
 */
public class Test {
    public static void main(String[] args) {
        Connection conn = null;
        try  {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/info?useSSL=false&serverTimezone=UTC&characterEncoding=utf-8"
                    , "root", "990708");
            conn.setAutoCommit(false); //默认自动提交
            //事务开始
            PreparedStatement ps1 = conn.prepareStatement("insert into t_user (username,pwd,regTime) values (?,?,?)");
            ps1.setObject(1, "张硕");
            ps1.setObject(2, "888888");
            ps1.setObject(3, new Date(System.currentTimeMillis()));
            ps1.execute();
            System.out.println("插入一个用户,张硕");

            try{
                Thread.sleep(6000);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }

            PreparedStatement ps2 = conn.prepareStatement("insert into t_user (username,pwd,regTime) values (?,?)");
            ps2.setObject(1, "郝建强");
            ps2.setObject(2, "777777");
            ps2.setObject(3, new Date(System.currentTimeMillis()));
            ps2.execute();
            System.out.println("插入一个用户,郝建强");

            conn.commit();
        }  catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
