package jdbc;

import java.io.*;
import java.sql.*;

/**
 * 测试CLOB 文本大对象的使用
 * 包含：将字符串，文件内容插入数据库中的CLOB字段，将CLOB字段值取出来操作
 */
public class ClobTest {
    public static void main(String[] args) {
        Connection conn = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/info?useSSL=false&" +
                    "serverTimezone=GMT%2B8&characterEncoding=utf-8","root","990708");

//            PreparedStatement ps = conn.prepareStatement("insert into time_test (name,intro) values (?,?)");
//
//            ps.setObject(1,"郝建强");
//        //    ps.setClob(2,new FileReader(new File("d:\\text1.txt")));
//            ps.setClob(2,new BufferedReader(new InputStreamReader(new ByteArrayInputStream(
//                    "hello world".getBytes()))));

            PreparedStatement ps = conn.prepareStatement("select * from time_test where id=?");
            ps.setObject(1,2001);

            rs = ps.executeQuery();
            while (rs.next()){
                System.out.print(rs.getInt("id")+"---"+rs.getString("name")+"---");
                Clob c = rs.getClob("intro");
                Reader r = c.getCharacterStream();
                int temp = 0;
                while ((temp = r.read()) != -1){
                    System.out.print((char)temp);
                }
                r.close();
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
