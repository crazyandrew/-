/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package 学生信息管理系统;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 *
 * @author Administrator
 */
public class DataProcessing {
    public static boolean addStudent(String name, String sex, String major, int grade, int classes) throws SQLException,IllegalStateException
    {
        
        String strCon = "jdbc:mysql://localhost:3306/tool";  //连接字符串
        String strUser = "root";               //数据库用户名
        String strPwd = "617079";                  //口令	   
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con;
            //获得连接对象
            con = DriverManager.getConnection(strCon, strUser, strPwd);//加载驱动程序
            //System.out.println("成功连接到数据库。")	     
            Statement sta = con.createStatement();
            //Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            //int rs = sta.executeUpdate("Insert Into student(ID,name,sex,major,grade,classes) Values" + "(" + "'" + ID + "'" + "," + "'" + name + "'" + "," + "'" + sex + "'" + "," + "'" + major + "'"+ "," + "'" + grade + "'"+ "," + "'" + classes + "'" + ")");
            int rs = sta.executeUpdate("Insert Into student(name,sex,major,grade,classes) Values" + "(" +  "'" + name + "'" + "," + "'" + sex + "'" + "," + "'" + major + "'"+ "," + "'" + grade + "'"+ "," + "'" + classes + "'" + ")");
            sta.close();
            con.close();//关闭所有已经打开的资源
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
    
    public static boolean deleteStudent(int ID)throws SQLException,IllegalStateException
    {
        String strCon = "jdbc:mysql://localhost:3306/tool";  //连接字符串
        String strUser = "root";               //数据库用户名
        String strPwd = "617079";                  //口令	   
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con;
            //获得连接对象
            con = DriverManager.getConnection(strCon, strUser, strPwd);//加载驱动程序
            //System.out.println("成功连接到数据库。")	     
            Statement sta = con.createStatement();
            int rs = sta.executeUpdate("Delete from student where ID="+"'"+ID+"'");
            //System.out.println("成功添加" + rs + "行数据。");
            sta.close();
            con.close();//关闭所有已经打开的资源
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
    
    public static boolean updateStudent(int ID, String name, String sex, String major, int grade, int classes)throws SQLException,IllegalStateException
    {
        String strCon = "jdbc:mysql://localhost:3306/tool";  //连接字符串
        String strUser = "root";               //数据库用户名
        String strPwd = "617079";                  //口令	   
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con;
            //获得连接对象
            con = DriverManager.getConnection(strCon, strUser, strPwd);//加载驱动程序
            //System.out.println("成功连接到数据库。")	     
            Statement sta = con.createStatement();
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            int rs = sta.executeUpdate("Update student set name="+"'"+name+"'"+","+"sex="+"'"+sex+"'"+","+"major="+"'"+major+"'"+","+"grade="+"'"+grade+"'"+","+"classes="+"'"+classes+"'" +"where ID="+"'"+ID+"'");
            //System.out.println("成功添加" + rs + "行数据。");
            sta.close();
            con.close();//关闭所有已经打开的资源
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
    
    public static student searchStudent(int ID)throws SQLException,IllegalStateException
    {
        String strCon = "jdbc:mysql://localhost:3306/tool";  //连接字符串
        String strUser = "root";               //数据库用户名
        String strPwd = "617079";                  //口令	   
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con;
            //获得连接对象
            con = DriverManager.getConnection(strCon, strUser, strPwd);//加载驱动程序
            //System.out.println("成功连接到数据库。")	     
            Statement sta = con.createStatement();
            ResultSet rs = sta.executeQuery("Select * from student where ID=" + "'" + ID + "'");
            //System.out.println("成功添加" + rs + "行数据。");
            int counter = 0;
            student st = new student();
            while (rs.next()) {
                counter++;
                String name = rs.getString("name");
                String sex = rs.getString("sex");
                String major = rs.getString("major");
                int grade = rs.getInt("grade");
                int classes = rs.getInt("classes");
                st = new student(ID, name, sex, major, grade, classes);
            }
            sta.close();
            con.close();//关闭所有已经打开的资源     
            if(counter==0){
                return null;
            }
            else{
                return st;
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    public static Enumeration<student> getAllStudent()throws SQLException,IllegalStateException
    {
        Hashtable<Integer,student> students=new Hashtable<>();
        String strCon = "jdbc:mysql://localhost:3306/tool";  //连接字符串
        String strUser = "root";               //数据库用户名
        String strPwd = "617079";                  //口令	   
        int ID;
        String name;
        String sex;
        String major;
        int grade;
        int classes;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con;
            //获得连接对象
            con = DriverManager.getConnection(strCon, strUser, strPwd);//加载驱动程序
            //System.out.println("成功连接到数据库。")	     
            Statement sta = con.createStatement();
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            ResultSet rs=sta.executeQuery("Select * from student ");
            while (rs.next()) {
                ID=rs.getInt("ID");
                name=rs.getString("name");
                sex=rs.getString("sex");
                major=rs.getString("major");
                grade=rs.getInt("grade");
                classes=rs.getInt("classes");
                students.put(ID, new student(ID, name, sex, major, grade, classes));
            }
            sta.close();
            con.close();//关闭所有已经打开的资源
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return students.elements();
    }
    
    public static void main(String[]args) throws SQLException
    {
        //addStudent("yw","men","cs",14,1);
        searchStudent(12);
        //updateStudent(112,"ss","women","bb",13,2);
        //getAllStudent();
    }
}
