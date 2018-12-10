package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCUtilTest {
    public static void main(String[] args) throws SQLException {
        Connection conn = JDBCUtil.getMysqlConn("info");

        PreparedStatement ps = conn.prepareStatement("insert into time_test (name) values (?)");
        ps.setObject(1,"张硕");
        ps.executeUpdate();
        JDBCUtil.close(conn);
    }
}
