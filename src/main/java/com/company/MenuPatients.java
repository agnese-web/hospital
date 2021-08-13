package com.company;

import com.company.hospitalControl.HospitalControl;

import java.util.HashSet;
import java.util.Scanner;

public class MenuPatients {
    public static void MenuPatients() {
        System.out.println("1.Admit patient and assign a doctor.");
        System.out.println("2.Edit patient.");
        System.out.println("3.Delete patient.");
        System.out.println("4.View patient details.");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Select an option: ");
        int option = scanner.nextInt();

        switch(option) {
            case 1:
                HospitalControl.addPatient();
                break;
            case 2:
                HospitalControl.editPatient();
                break;
            case 3:
                HospitalControl.deletePatient();
                break;
            case 4:
                HospitalControl.getPatientById();
                break;
            default:
                System.out.println("Choose one of the above");
        }
    }

}
