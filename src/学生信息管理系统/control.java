/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package 学生信息管理系统;

import java.sql.SQLException;
import java.util.Enumeration;

/**
 *
 * @author Administrator
 */
public class control {
    public static void addStudent(String name, String sex, String major, int grade, int classes) throws SQLException
    {
        DataProcessing.addStudent(name, sex, major, grade, classes);
    }
    public static void deleteStudent(int ID) throws SQLException
    {
        DataProcessing.deleteStudent(ID);
    }
    public static void updateStudent(int ID, String name, String sex, String major, int grade, int classes) throws SQLException
    {
        DataProcessing.updateStudent(ID, name, sex, major, grade, classes);
    }
    public static student searchStudent(int ID) throws SQLException
    {
        return DataProcessing.searchStudent(ID);
    }
    public static Enumeration<student> getAllStudent() throws SQLException
    {
       return DataProcessing.getAllStudent();
    }
}
