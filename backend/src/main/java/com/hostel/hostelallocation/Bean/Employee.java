package com.hostel.hostelallocation.Bean;

import jakarta.persistence.*;
import com.hostel.hostelallocation.DAO.EmployeeDAO;
import com.hostel.hostelallocation.DAO.DAOImplement.EmployeeDAOImpl;
//will only use this class to login an employee
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "emp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;

    @Column(name = "fname",nullable = false)
    private String emp_fname;

    @Column(name = "lname")
    private String emp_lname;

    @Column(name = "email",nullable = false, unique = true)
    private String emp_email;

    @Column(name = "password",nullable = false, length = 6)
    private String emp_pass;

    @Column(name = "department", nullable = false)
    private String emp_dept;

    public Employee(){

    }

    public Employee(int empId, String emp_fname, String emp_lname, String emp_email, String emp_pass, String emp_dept) {
        this.empId = empId;
        this.emp_fname = emp_fname;
        this.emp_lname = emp_lname;
        this.emp_email = emp_email;
        this.emp_pass = emp_pass;
        this.emp_dept = emp_dept;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmp_fname() {
        return emp_fname;
    }

    public void setEmp_fname(String emp_fname) {
        this.emp_fname = emp_fname;
    }

    public String getEmp_lname() {
        return emp_lname;
    }

    public void setEmp_lname(String emp_lname) {
        this.emp_lname = emp_lname;
    }

    public String getEmp_email() {
        return emp_email;
    }

    public void setEmp_email(String emp_email) {
        this.emp_email = emp_email;
    }

    public String getEmp_pass() {
        return emp_pass;
    }

    public void setEmp_pass(String emp_pass) {
        this.emp_pass = emp_pass;
    }

    public String getEmp_dept() {
        return emp_dept;
    }

    public void setEmp_dept(String emp_dept) {
        this.emp_dept = emp_dept;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", emp_fname='" + emp_fname + '\'' +
                ", emp_lname='" + emp_lname + '\'' +
                ", emp_email='" + emp_email + '\'' +
                ", emp_pass='" + emp_pass + '\'' +
                ", emp_dept='" + emp_dept + '\''+
                '}';
    }

    public static Employee login(Employee emp){
        EmployeeDAOImpl empDAO = new EmployeeDAOImpl();
        Employee loggedInEmp = empDAO.login(emp);

        // If no login happens, then return null
        if (loggedInEmp == null)
            return null;

        // Setting billList to null to avoid cyclic dependency issues
        //loggedInEmp.setBillList(null);

        return loggedInEmp;
    }
}
