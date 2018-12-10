package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 测试执行sql语句
 */
public class StatementTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //加载驱动类
        Class.forName("com.mysql.jdbc.Driver");
        //建立连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/info?useSSL=false&serverTimezone=UTC&characterEncoding=utf-8","root",
                "990708");
        Statement stmt = conn.createStatement();

//        String sql = "insert into t_user (username,pwd,regTime) values ('曾帅智',555,now())";
//        stmt.execute(sql);

        //测试sql注入
        String id = "5 or 1=1";
        String sql = "delete from t_user where id=" + id;
        stmt.execute(sql);

        if (stmt != null){
            stmt.close();
        }

        if (conn != null){
            conn.close();
        }
    }
}
