package com.hostel.hostelallocation.Bean;
import jakarta.persistence.*;
@Entity
@Table(name = "students")
public class Students {
    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;

    @Column(name = "roll_number", nullable = false, unique = true)
    private short rollNumber;

    @Column(name = "first_name", nullable = false)
    private String Fname;

    @Column(name = "last_name")
    private String Lname;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "graduation_year")
    private short gradYear;

    public Students(){

    }

    public Students(Integer studentId, short rollNumber, String fname, String lname, String email, short gradYear) {
        this.studentId = studentId;
        this.rollNumber = rollNumber;
        Fname = fname;
        Lname = lname;
        this.email = email;
        this.gradYear = gradYear;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public short getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(short rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public short getGradYear() {
        return gradYear;
    }

    public void setGradYear(short gradYear) {
        this.gradYear = gradYear;
    }

    @Override
    public String toString() {
        return "Students{" +
                "studentId=" + studentId +
                ", rollNumber=" + rollNumber +
                ", Fname='" + Fname + '\'' +
                ", Lname='" + Lname + '\'' +
                ", gradYear=" + gradYear +
                '}';
    }

}
