package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * PreparedStatement对象比Statement对象的效率更高
 * 可以防止sql注入
 */
public class PreparedStatementTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/info?useSSL=false&serverTimezone=UTC&characterEncoding=utf-8"
        ,"root","990708");
        String sql = "insert into m_user (managername,pwd) values (?,?)";  // ?占位符
        PreparedStatement ps = conn.prepareStatement(sql);
//        ps.setString(1,"师东璇");  //参数索引从1开始算
//        ps.setString(2,"990708");

        ps.setObject(1,"张硕");
        ps.setObject(2,"999999");

        System.out.println("插入一行记录");
        ps.execute();

        if (ps != null ){
            ps.close();
        }

        if (conn != null){
            conn.close();
        }

    }
}
