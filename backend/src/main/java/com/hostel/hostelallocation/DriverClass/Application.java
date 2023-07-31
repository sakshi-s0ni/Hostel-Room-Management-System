package com.hostel.hostelallocation.DriverClass;

import com.hostel.hostelallocation.Bean.Students;
import com.hostel.hostelallocation.DAO.DAOImplement.StudentDAOImpl;
import com.hostel.hostelallocation.DAO.StudentDAO;

public class Application {
    public static void main(String args[]){
        System.out.println("Application Started");
        runApplication();
        System.out.println("End");
    }
    private static void runApplication() {
        Students s1 = new Students();
        s1.setFname("Parul");
        s1.setLname("G");
        s1.setRollNumber((short) 2);
        s1.setStudentId(2);
        s1.setEmail("parul@gmail.com");
        s1.setGradYear((short) 2024);
        StudentDAO studObj = new StudentDAOImpl();
        studObj.addStudent(s1);
    }
}