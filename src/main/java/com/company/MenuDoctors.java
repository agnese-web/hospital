package com.company;

import com.company.hospitalControl.HospitalControl;

import java.util.Scanner;

public class MenuDoctors {
    public static void MenuDoctors() {

        System.out.println("What would You like to do?");
        System.out.println("1.Add doctor.");
        System.out.println("2.Edit doctor.");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Select an option: ");
        int option = scanner.nextInt();

        switch(option) {
            case 1:
                HospitalControl.addDoctor();
                break;
            case 2:
                HospitalControl.editDoctor();
                break;
            default:
                System.out.println("Pick one of the above");
        }
    }
}
