package jdbc;

import com.sun.org.apache.xpath.internal.operations.String;
import sun.reflect.generics.tree.Tree;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.lang.Thread.sleep;

/**
 * 测试与数据库建立连接
 */
public class ConnectionTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //加载驱动类
        Class.forName("com.mysql.jdbc.Driver");
        //建立连接(连接对象内部其实包含了Socket对象，是一个远程的连接。比较耗时！这是Connection对象管理的一个要点)
        //真正开发中，为了调高效率，大家都会用连接池来管理连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/info?useSSL=false&serverTimezone=UTC&characterEncoding=utf-8"
                ,"root", "990708");

        if (conn != null){
            conn.close();
        }

    }
}

