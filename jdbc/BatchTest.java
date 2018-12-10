package jdbc;

import java.sql.*;

/**
 * 测试批处理的基本用法
 */
public class BatchTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/info?useSSL=false&serverTimezone=UTC&characterEncoding=utf-8"
        ,"root","990708");
        String sql = "";
        Statement stmt = null;

        conn.setAutoCommit(false);  //设为手动提交

        stmt = conn.createStatement();

        for (int i = 0; i < 20000; i++){
            stmt.addBatch("insert into m_user (managername,pwd) values ('shi"+i+"',999999 )");
        }
        stmt.executeBatch();
        conn.commit();
    }
}
