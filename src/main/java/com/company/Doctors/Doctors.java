package com.company.Doctors;

import com.company.Db.DbConn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Doctors {

    int id;
    String name, speciality;

    public Doctors(int id, String name, String speciality){
        this.id = id;
        this.name= name;
        this.speciality = speciality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }





}
