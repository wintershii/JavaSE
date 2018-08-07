package jdbc;

import java.sql.*;
import java.util.Collections;

/**
 * 测试事件处理(Date,Time,Timestamp)
 */
public class DateCompareTest {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/info?useSSL=false" +
                            "&serverTimezone=GMT%2B8&charset=utf-8"
                        ,"root","990708");
            PreparedStatement ps = conn.prepareStatement("insert into t_user (username,pwd,regTime) values (?,?,?)");
            ps.setObject(1,"郝建强");
            ps.setObject(2,"777777");

          //  Date date = new java.sql.Date(System.currentTimeMillis());

            Timestamp stamp = new Timestamp(System.currentTimeMillis());
            ps.setObject(3,stamp);

            ps.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
