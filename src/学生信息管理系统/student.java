/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package 学生信息管理系统;

/**
 *
 * @author Administrator
 */
public class student {
    private int ID;
    private String name;
    private String sex;
    private String major;
    private int grade;
    private int classes;

    public student(){
        
    }
    
    public student(int ID, String name, String sex, String major, int grade, int classes) {
        this.ID = ID;
        this.name = name;
        this.sex = sex;
        this.major = major;
        this.grade = grade;
        this.classes = classes;
    }
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getClasses() {
        return classes;
    }

    public void setClasses(int classes) {
        this.classes = classes;
    }
    
}
