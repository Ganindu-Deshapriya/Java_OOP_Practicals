/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labsheet7_2;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Surgeon extends Doctor {
    private List<String> patientRecords;
    private spec spec;

    public Surgeon(String empNo, String name, String regNo, spec spec) {
        super(empNo, name, regNo);
        this.spec = spec;
        patientRecords = new ArrayList<>();
    }

    public void opPatients() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Patient name   : ");
        String name = sc.nextLine();
        System.out.print("Enter Admitted date  : ");
        String date = sc.nextLine();
        System.out.print("Enter Bedhead Ticket : ");
        String ticket = sc.nextLine();

        String patientInfo = "Patient: " + name + ", Admitted on: " + date + "\nBedhead Ticket: " + ticket;
        patientRecords.add(patientInfo);

        System.out.println("Successfully recorded patient information.");
    }

    public void displayPatientRecords() {
        System.out.println("Patient Records for " + getName() + " (" + getRegNo() + "):");
        for (String record : patientRecords) {
            System.out.println(record);
        }
    }

    spec getspec() {
        return spec;
    }
}
