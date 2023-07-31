package com.hostel.hostelallocation.Bean;
import jakarta.persistence.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hostels")
public class Hostel {
    @Id
    @Column(name = "hostel_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hostelId;

    @Column(name = "name" , nullable = false)
    private String hostelName;

    @Column(name = "floor" , nullable = false)
    private Integer floor;

    @Column(name = "room_number" , nullable = false , unique = true)
    private short roomNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="stud_hostel_fk",referencedColumnName = "student_id", unique = true)
    private Students studHostelFk;
    //private List<Students> studentsList;


    public Hostel(){
    }

    public Hostel(int hostelId, String hostelName, Integer floor, short roomNumber, Students studHostelFk) {
        this.hostelId = hostelId;
        this.hostelName = hostelName;
        this.floor = floor;
        this.roomNumber = roomNumber;
        this.studHostelFk = studHostelFk;
        //this.studentsList = studentsList;
    }

    public int getHostelId() {
        return hostelId;
    }

    public void setHostelId(int hostelId) {
        this.hostelId = hostelId;
    }

    public String getHostelName() {
        return hostelName;
    }

    public void setHostelName(String hostelName) {
        this.hostelName = hostelName;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public short getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(short roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Students getStudHostelFk() {
        return studHostelFk;
    }

    public void setStudHostelFk(Students studHostelFk) {
        this.studHostelFk = studHostelFk;
    }

    @Override
    public String toString() {
        return "Hostel{" +
                "hostelId=" + hostelId +
                ", hostelName='" + hostelName + '\'' +
                ", floor=" + floor +
                ", roomNumber=" + roomNumber +
                ", studHostelFk=" + studHostelFk +
                '}';
    }
}
