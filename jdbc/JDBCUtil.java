package jdbc;

import java.sql.*;

public class JDBCUtil {
    public static Connection getMysqlConn(String database){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+database+"?useSSL=false&" +
                    "serverTimezone=GMT%2B8&characterEncoding=utf-8","root","990708");

            return conn;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
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
