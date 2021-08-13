package com.company;
import com.company.hospitalControl.HospitalControl;

import java.sql.SQLException;
import java.util.Scanner;
public class Menu {
    public static void Menu(){

        System.out.println("What category do You want to work with? ");

        System.out.println("1. Doctors");
        System.out.println("2. Patients");
        System.out.println("3. Drugs");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Select an option: ");
        int option = scanner.nextInt();

        switch(option) {
            case 1:
                MenuDoctors.MenuDoctors();
                break;
            case 2:
                MenuPatients.MenuPatients();
                break;
            case 3:
                MenuDrugs.MenuDrugs();
                break;
            default:
                System.out.println("No such option");
        }
    }
}
