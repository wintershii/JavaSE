package jdbc;

import java.sql.*;

/**
 * 测试ResultSet结果集的基本用法
 */
public class PreparedStatementTest2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/info?useSSL=false&serverTimezone=UTC&characterEncoding=utf-8"
                , "root","990708");

        String sql = "select id,managername,pwd from m_user where id>?";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setObject(1,2);
        ResultSet rs = ps.executeQuery();

        while (rs.next()){
            System.out.println(rs.getInt(1)+"---"+rs.getString(2)+
                    "---"+rs.getString(3));
        }

        if (rs != null){
            rs.close();
        }

        if (ps != null){
            ps.close();
        }
        if (conn != null){
            conn.close();
        }
    }
}
