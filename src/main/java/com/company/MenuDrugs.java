package com.company;

import com.company.hospitalControl.HospitalControl;

import java.util.Scanner;

public class MenuDrugs {
    public static void MenuDrugs() {
        System.out.println("1.Add drug.");
        System.out.println("2.Give patient necessary drugs.");


        Scanner scanner = new Scanner(System.in);
        System.out.print("Select an option: ");
        int option = scanner.nextInt();

        switch(option){
            case 1:
                HospitalControl.addDrug();
                break;
            case 2:
                HospitalControl.giveDrug();
                break;
            default:
                System.out.println("Choose one of the above");
        }

    }
}
