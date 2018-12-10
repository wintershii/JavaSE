package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ORM(Object relationship Mapping)的基本思想
 * - 表结构跟类对应；表中字段和类的属性对应；表中记录和对象对应
 * - 让javabean的属性名和类型尽量和数据库保持一致
 * - 一条记录对应一个对象。将这些查询到的对象放到容器中(List，Set，Map)
 */
public class ORMTest {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Employee emp = null;
        List<Employee> list = new ArrayList<>();
        try {
            conn = JDBCUtil.getMysqlConn("srom");
            ps = conn.prepareStatement("select empname,salary,hireDate,age,departId " +
                    "from employee where id > ?");
            ps.setObject(1,0);

            rs = ps.executeQuery();

            while (rs.next()){
                emp = new Employee(rs.getString("empname"),rs.getDouble("salary")
                            ,rs.getDate("hireDate"),rs.getInt("age")
                        ,rs.getInt("departId"));
                list.add(emp);
            }

            Iterator it = list.iterator();
            while (it.hasNext()) {
                Employee temp = (Employee) it.next();
                System.out.println(temp.getEmpname() + "--" + temp.getSalary() + "--" + temp.getHireDate() +
                        "--" + temp.getAge() + "--" + temp.getDepartId());
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JDBCUtil.close(ps,conn);
        }
    }
}
