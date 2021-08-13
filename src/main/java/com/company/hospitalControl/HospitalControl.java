package com.company.hospitalControl;
import com.company.Doctors.Doctors;
import com.company.Patients.Patient;
import com.company.Drugs.Drugs;
import com.company.Db.DbConn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class HospitalControl {

    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;



    // DOCTORS

    public static void addDoctor() {

        System.out.print("Enter the name: ");
        String name = scanner.next();

        System.out.print("Enter the speciality: ");
        String speciality = scanner.next();
        try {
            ps = DbConn.getConnection().prepareStatement("INSERT INTO doctors(name, spec)" +
                    " VALUES('" + name + "', '" + speciality + "')");
            ps.execute();

            System.out.println("Successfully added new doctor.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void editDoctor() {

        System.out.print("Enter the doctor's id: ");
        int doctorId = scanner.nextInt();

        System.out.println("name, spec");
        System.out.print("Enter the field you want to edit: ");
        String field = scanner.next();

        System.out.print("Enter the updated value: ");
        String update = scanner.next();

        try {
            ps = DbConn.getConnection().prepareStatement("UPDATE doctors SET " + field + " = '" + update + "' WHERE id = " + doctorId);
            ps.execute();
            System.out.println("Successfully updated doctor.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public static void deleteDoctor() {
        System.out.print("Enter doctor's id: ");
        int id = scanner.nextInt();

        try {
            ps = DbConn.getConnection().prepareStatement("DELETE FROM doctors WHERE id= "+ id);
            ps.execute();
            System.out.println("Successfully deleted doctor from hospital records");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Doctors getDoctorById() {
        System.out.print("Enter the id of the patient: ");
        int id = scanner.nextInt();

        try {
            ps = DbConn.getConnection().prepareStatement("SELECT * FROM doctors WHERE id=" + id);
            rs = ps.executeQuery();

            int doctorId = 0;

            String name = "";
            String speciality = "";

            Doctors doctor = new Doctors(id, name, speciality);
            while (rs.next()) {
                doctorId = rs.getInt("id");
                name = rs.getString("name");
                speciality = rs.getString("spec");
                doctor.setId(id);
                doctor.setName(name);
                doctor.setSpeciality(speciality);

            }
            System.out.println("Doctor ID no. " + id + " is " + name + " and is currently in " + speciality + " department");
            return doctor;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    // PATIENTS
    public static void addPatient() {
        System.out.print("Enter name: ");
        String namePatient = scanner.next();

        System.out.print("Enter age: ");
        String agePatient = scanner.next();

        System.out.print("Enter sickness: ");
        String sicknessPatient = scanner.next();

        System.out.println("Assign doctor ID: ");
        int doctor = scanner.nextInt();

        try {
            ps = DbConn.getConnection().prepareStatement("INSERT INTO patients(name, age, sickness, doctors_id)" +
                    " VALUES('" + namePatient + "', '" + agePatient + "', '" + sicknessPatient + "', '" + doctor + "')");
            ps.execute();

            System.out.println("Successfully added new patient.");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void editPatient() {

        System.out.print("Enter the patient's id: ");
        int patientId = scanner.nextInt();

        System.out.println("name, age, sickness");
        System.out.print("Enter the field you want to edit: ");
        String field = scanner.next();

        System.out.print("Enter the updated value: ");
        String update = scanner.next();

        try {
            ps = DbConn.getConnection().prepareStatement("UPDATE patients SET " + field + " = '" + update + "' WHERE patient_id = " + patientId);
            ps.execute();
            System.out.println("Successfully updated patient.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deletePatient() {

        System.out.print("Enter patient's id: ");
        int patientId = scanner.nextInt();

        try {
            ps = DbConn.getConnection().prepareStatement("DELETE FROM patients WHERE patient_id=" + patientId);
            ps.execute();
            System.out.println("Patient is deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public static Patient getPatientById() {
        System.out.print("Enter the id of the patient: ");
        int id = scanner.nextInt();

        try {
            ps = DbConn.getConnection().prepareStatement("SELECT * FROM patients WHERE patient_id=" + id);
            rs = ps.executeQuery();

            int patientId = 0;
            int age  = 0;
            String name = "";
            String sickness = "";
            int doctors_id = 0;

            Patient patient = new Patient(id, name, age, sickness, doctors_id);
            while (rs.next()) {
                patientId = rs.getInt("patient_id");
                name = rs.getString("name");
                age = rs.getInt("age");
                sickness = rs.getString("sickness");
                doctors_id = rs.getInt("doctors_id");
                patient.setId(id);
                patient.setName(name);
                patient.setAge(age);
                patient.setSickness(sickness);
                patient.setDoctors_id(doctors_id);

            }
            System.out.println("Patient ID no. " + id + " is " + name + " , " + age + " years old, complaining of " + sickness + " and is assigned to Doctor " + doctors_id);
            return patient;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void assignPatient() {
        System.out.println("Enter the patient ID: ");
        int patientId = scanner.nextInt();

        System.out.println("Enter the doctor ID: ");
        int doctorId = scanner.nextInt();



        try {
            ps = DbConn.getConnection().prepareStatement("INSERT INTO doctors (patient_id, doctors_id) " +
                    " VALUES(" + patientId + ", " + doctorId + ")");
            ps.execute();
            System.out.println("Successfully assigned patient to doctor");
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }



    // DRUGS

    public static void addDrug() {
        System.out.print("Enter name of the drug: ");
        String nameDrug = scanner.next();

        System.out.print("For what is it meant: ");
        String forWhat = scanner.next();

        System.out.print("Will be given to patient: ");
        int given = scanner.nextInt();

        try {
            ps = DbConn.getConnection().prepareStatement("INSERT INTO drugs(name, forwhat, given)" +
                    " VALUES('" + nameDrug + "', '" + forWhat + "', '" + given + "')");
            ps.execute();

            System.out.println("Successfully added new drug.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Drugs getDrugById() {
        System.out.print("Enter the drug ID: ");
        int id = scanner.nextInt();



        try {
            ps = DbConn.getConnection().prepareStatement("SELECT * FROM drugs WHERE drug_id=" + id);
            rs = ps.executeQuery();

            int drugId = 0;

            String name = "";
            String forwhat = "";

            Drugs drug = new Drugs();
            while (rs.next()) {
                drugId = rs.getInt("drug_id");
                name = rs.getString("name");
                forwhat = rs.getString("forwhat");
                drug.setId(id);
                drug.setName(name);
                drug.setForwhat(forwhat);

            }
            System.out.println("Drug ID no. " + id + " is " + name + " and is meant for " + forwhat);
            return drug;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static Drugs giveDrug() {
        System.out.println("Choose drug ID: ");
        int id = scanner.nextInt();
        System.out.println("Enter the patient ID: ");
        int given = scanner.nextInt();
        try {
            ps = DbConn.getConnection().prepareStatement("SELECT * FROM drugs WHERE drug_id=" + id);
            ps = DbConn.getConnection().prepareStatement("SELECT * FROM drugs WHERE given=" + given);
            rs = ps.executeQuery();

            int drugId = 0;

            String name = "";
            String forwhat = "";

            Drugs drug = new Drugs();
            while (rs.next()) {
                drugId = rs.getInt("drug_id");
                name = rs.getString("name");
                forwhat = rs.getString("forwhat");
                given = rs.getInt("given");
                drug.setId(id);
                drug.setName(name);
                drug.setForwhat(forwhat);
                drug.setGiven(given);
            }
            System.out.println("Drug ID no. " + id + " is " + name + " is meant for " + forwhat + " and is given to patient " + given);
            return drug;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }






}
