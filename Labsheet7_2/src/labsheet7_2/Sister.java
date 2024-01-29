/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labsheet7_2;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sister extends Nurse {
    private List<String> wardVisits;

    public Sister(String empNo, String name, String regNo) {
        super(empNo, name, regNo);
        wardVisits = new ArrayList<>();
    }

    public void visited() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Ward Number: ");
        String wardNo = sc.nextLine();
        String visitInfo = LocalDate.now() + " : Visited ward no: " + wardNo;

        wardVisits.add(visitInfo);

        System.out.println("Successfully recorded the visit.");
    }

    public void displayVisits() {
        System.out.println("Ward Visits for " + getName() + " (" + getRegNo() + "):");
        for (String visit : wardVisits) {
            System.out.println(visit);
        }
    }
}
