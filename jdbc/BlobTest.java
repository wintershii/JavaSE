package jdbc;

import com.mysql.cj.jdbc.Blob;

import java.io.*;
import java.sql.*;

/**
 * 测试BLOB  二进制大对象的使用
 *
 */
public class BlobTest {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/info?useSSL=false&" +
                    "serverTimezone=GMT%2B8&characterEncoding=utf-8","root","990708");
            ps = conn.prepareStatement("select name,headimg from time_test where id=?");

//            ps.setObject(1,"张硕");
//            ps.setObject(2,new Timestamp(System.currentTimeMillis()));
//            ps.setBlob(3,new BufferedInputStream(new FileInputStream(
//                    new File("d:\\abc.png"))));

            ps.setObject(1,2003);
            //ps.executeUpdate();

            rs = ps.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString("name"));
                Blob c = (Blob) rs.getBlob("headimg");
                InputStream is = c.getBinaryStream();
                OutputStream os = new FileOutputStream("d:\\test.png");
                int temp = 0;
                while ((temp = is.read()) != -1) {
                    os.write(temp);
                }
                os.close();
                is.close();
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
