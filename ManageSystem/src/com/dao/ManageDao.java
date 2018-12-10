package com.dao;

import com.model.Student;
import com.model.Teacher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



/**
 * 登陆时从数据库获取并判断账号密码是否正确
 */
public class ManageDao {
    public  boolean manageLogIn(String manageId, String pwd) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement("select manageId,pwd from mangeInfo");
            rs = ps.executeQuery();
            String user = null;
            String realPwd = null;
            while (rs.next()) {
                user = rs.getString("manageId");
                realPwd = rs.getString("pwd");

                if (user.equals(manageId) && realPwd.equals(pwd)) {

                    return true;
                }
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("sql语句输入错误");
            JDBCUtil.close(rs, ps, conn);
            return false;
        }
    }

    /**
     *  新增管理员信息进入数据库
     * @param manageId
     * @param pwd
     * @param manageName
     * @param phone
     * @return
     */
    public  boolean newManagerDao(String manageId,String pwd,String manageName,String phone){
        Connection conn = JDBCUtil.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("insert into mangeinfo (manageId" +
                    ",pwd,manageName,phone) values (?,?,?,?)");
            ps.setString(1, manageId);
            ps.setString(2, pwd);
            ps.setString(3, manageName);
            ps.setString(4, phone);
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }
    }

    /**
     * 新增教师信息进入数据库
     * @param teachId
     * @param pwd
     * @param teachName
     * @param phone
     * @param teachMajor
     * @param subject
     * @return
     */
    public  boolean newTeacherDao(String teachId,String pwd,String teachName,
                                     String phone,String teachMajor,String subject){

        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement("insert into teachinfo (teachId,pwd,teachName,phone,major,subject)" +
                    "values (?,?,?,?,?,?)");
            ps.setString(1,teachId);
            ps.setString(2,pwd);
            ps.setString(3,teachName);
            ps.setString(4,phone);
            ps.setString(5,teachMajor);
            ps.setString(6,subject);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            JDBCUtil.close(ps,conn);
            return false;
        }
    }

    /**
     * 将指定用户名的教师从数据库中删除
     * @param teachId
     * @return
     */
    public  boolean deleteTeacherDao(String teachId){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement("delete from teachInfo where teachId = ?");
            ps.setString(1,teachId);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("sql语句错误");
            return  false;
        }
    }

    /**
     * 从数据库中获取指定用户名的教师信息，并实例化为一个Teacher类并返回
     * @param teachId
     * @return
     */
    public Teacher printTeacherDao(String teachId){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement("select * from teachInfo where teachId = ?");
            ps.setString(1,teachId);
            rs = ps.executeQuery();
            Teacher teach = new Teacher();
            while (rs.next()){
                teach.setUser(rs.getString("teachId"));
                teach.setPwd(rs.getString("pwd"));
                teach.setName(rs.getString("teachName"));
                teach.setPhone(rs.getString("phone"));
                teach.setMajor(rs.getString("major"));
                teach.setSubject(rs.getString("subject"));
            }
            return teach;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("未找到该教师！");
            return  null;
        }
    }

    /**
     *  在数据库中修改指定用户名的教师的指定列的信息
     * @param teachId
     * @param column
     * @param newInfo
     * @return
     */
    public boolean alterTeacherDao(String teachId,String column, String newInfo){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement("UPDATE teachInfo set " + column + " = ? where teachId = ?");
            ps.setString(1,newInfo);
            ps.setString(2,teachId);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     *  从数据库中获取所有教师的用户名信息，并在service层调用()
     * @return
     */
    public List<String> printAllTeacherDao(){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<String> list = new ArrayList<>();
        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement("select teachId from teachInfo");
            rs = ps.executeQuery();
            while (rs.next()){
                String str = rs.getString("teachId");
                list.add(str);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     *  新增学生信息进入数据库
     * @param user
     * @param pwd
     * @param name
     * @param phone
     * @param major
     * @param classroom
     * @param serial
     * @param entranceTime
     * @return
     */
    public boolean newStudentDao(String user,String pwd,String name,String phone,String major,String classroom,
                                    Integer serial, Date entranceTime){
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement("insert into stuifo (userId,pwd,stuName,phone,major,classroom" +
                    ",serial,entranceTime) values (?,?,?,?,?,?,?,?)");
            ps.setString(1,user);
            ps.setString(2,pwd);
            ps.setString(3,name);
            ps.setString(4,phone);
            ps.setString(5,major);
            ps.setString(6,classroom);
            ps.setInt(7,serial);
            ps.setDate(8,entranceTime);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 在数据库中删除指定用户名的学生的信息
     * @param user
     * @return
     */
    public boolean deleteStudentDao(String user){
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement("delete from stuifo where userId = ?");
            ps.setString(1,user);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     *  返回指定专业或所有学生的信息的List容器对象
     * @param major
     * @return
     */
    public List<Student> printAllStudentDao(String major){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Student> list = new ArrayList<>();
        try {
            conn = JDBCUtil.getConnection();
            if (!major.equals("*")){
                ps = conn.prepareStatement("select * from stuifo where major = ? order by classroom asc ");
                ps.setString(1,major);
            }else {
                ps = conn.prepareStatement("select * from stuifo order by major asc");
            }
            rs = ps.executeQuery();
            while (rs.next()){
                Student stu = new Student();
                stu.setUser(rs.getString("userId"));
                stu.setPwd(rs.getString("pwd"));
                stu.setName(rs.getString("stuName"));
                stu.setPhone(rs.getString("phone"));
                stu.setMajor(rs.getString("major"));
                stu.setClassroom(rs.getInt("classroom"));
                stu.setSerial(rs.getInt("serial"));
                list.add(stu);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
