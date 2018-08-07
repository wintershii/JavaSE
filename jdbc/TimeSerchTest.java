package jdbc;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 取出指定时间段的内容
 */
public class TimeSerchTest {

    /**
     * 日期时间字符串转长整形数
     * @param dateStr
     */
    public static long str2Date(String dateStr){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            return format.parse(dateStr).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }


    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/info?useSSL=false&" +
                    "serverTimezone=GMT%2B8&charset=utf-8","root","990708");
//            for (int i = 0; i < 1000; i++) {
//                String sql = "insert into time_test (name,regTime) values (?,?)";
//                PreparedStatement ps = conn.prepareStatement(sql);
//                ps.setObject(1,"师东璇" + i + "号");
//
//                int rand = (int) (1000000000 + Math.random()*1000000000);
//                Timestamp stamp = new Timestamp(System.currentTimeMillis()-rand);
//
//                ps.setObject(2,stamp);
            ps = conn.prepareStatement("select * from time_test where regTime>? and regTime<?");

            Timestamp start = new Timestamp(str2Date("2018-07-20 00:00:00"));
            Timestamp end = new Timestamp(str2Date("2018-07-23 00:00:00"));


            ps.setObject(1,start);
            ps.setObject(2,end);


                rs = ps.executeQuery();

                while (rs.next()){
                    System.out.println(rs.getInt("id")+"---"+rs.getString("name")+"---"
                            +rs.getTimestamp("regTime"));
                }

            } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }
}
