package com.company.Patients;

import com.company.Db.DbConn;


public class Patient {
    private int id, age, doctors_id;
    private String name, sickness;

    public Patient(int id, String name, int age, String sickness, int doctors_id) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sickness = sickness;
        this.doctors_id = doctors_id;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSickness() {
        return sickness;
    }

    public void setSickness(String sickness) {
        this.sickness = sickness;
    }

    public int getDoctorsId (){
        return doctors_id;
    }
    public void setDoctors_id(int doctors_id) {
        this.doctors_id = doctors_id;
    }
}