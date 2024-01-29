package labsheet7_2;

import java.util.HashMap;
import java.util.Scanner;

public class Labsheet7_2 {
    static Scanner sc = new Scanner(System.in);

    static HashMap<String, Nurse> nurseList = new HashMap<>();
    static HashMap<String, Sister> sisterList = new HashMap<>();
    static HashMap<String, Doctor> doctorList = new HashMap<>();
    static HashMap<String, Surgeon> surgeonList = new HashMap<>();
    static HashMap<String, Ward> wardList = new HashMap<>();

    static Employee emp;
    static spec spec;

    public static void main(String[] args) {
        int i = 1;
        do {
            i = mainMenu();
        } while (i != 0);
    }

    public static int mainMenu() {
        String name, no, regNo;
        int shift, i = 1;

        System.out.println("""
                1. Add Employee
                2. Add Ward
                3. Update House Officer
                4. Update shift
                5. Add Operated Patient 
                6. Add Ward visits
                7. Get employee details
                8. Exit""");
        System.out.print("\nEnter Choice : ");
        int ch = sc.nextInt();
        sc.nextLine();

        switch (ch) {
            case 1:
                System.out.print("Enter Name : ");
                name = sc.nextLine();
                System.out.print("Enter Employee no : ");
                no = sc.nextLine();
                shift = selectShift();

                switch (selectEmp()) {
                    case 1 -> {
                        System.out.print("Enter SLMC no : ");
                        regNo = sc.nextLine();

                        System.out.println("Select specialization : ");
                        selectSpec();

                        if ((shift > 0) && (shift < 5)) {
                            Surgeon obj = new Surgeon(no, name, regNo, spec);
                            surgeonList.put(no, obj);
                            System.out.println("Record Created");
                        } else {
                            System.out.println("Invalid shift (ERR)");
                        }
                    }

                    case 2 -> {
                        System.out.print("Enter SLMC no : ");
                        regNo = sc.nextLine();

                        if ((shift > 0) && (shift < 4)) {
                            Doctor obj = new Doctor(no, name, regNo);
                            doctorList.put(no, obj);
                            System.out.println("Record Created");
                        } else {
                            System.out.println("Invalid shift(ERR)");
                        }
                    }

                    
                    case 3 -> {
                        System.out.print("Enter Nurse Registration no : ");
                        regNo = sc.nextLine();

                        if ((shift > 0) && (shift < 4)) {
                            Sister obj = new Sister(no, name, regNo);
                            sisterList.put(no, obj);
                            System.out.println("SUCCESS : Record Created");
                        } else {
                            System.out.println("ERROR : Invalid shift");
                        }
                    }
                    
                    case 4 -> {
                        System.out.print("Enter Nurse Registration no : ");
                        regNo = sc.nextLine();

                        if ((shift > 0) && (shift < 4)) {
                            Nurse obj = new Nurse(no, name, regNo);
                            nurseList.put(no, obj);
                            System.out.println("SUCCESS : Record Created");
                        } else {
                            System.out.println("ERROR : Invalid shift");
                        }
                    }

                    
                }
                System.out.println("\nPress 'ENTER' to continue");
                sc.nextLine();
                break;

            case 2:
                System.out.print("Enter Ward Name : ");
                name = sc.nextLine();
                System.out.print("Ward no         : ");
                no = sc.nextLine();
                System.out.println("Select Type     : ");
                selectSpec();

                wardList.put(no, new Ward(name, no, spec));
                System.out.println("SUCCESS : Record Created");
                break;
                
                
            case 3:
                System.out.print("Enter Ward Name   : ");
                name = sc.nextLine();

                System.out.print("Enter Employee no : ");
                no = sc.nextLine();
                wardList.get(name).setHO(no);
                break;
                
            case 4:
                System.out.print("Enter Employee no : ");
                no = sc.nextLine();
                shift = selectShift();

                if (surgeonList.containsKey(no)) {
                    emp = surgeonList.get(no);
                } else if (doctorList.containsKey(no)) {
                    emp = doctorList.get(no);
                } else if (sisterList.containsKey(no)) {
                    emp = sisterList.get(no);
                } else if (nurseList.containsKey(no)) {
                    emp = nurseList.get(no);
                } else {
                    shift = 0;
                }

                if ((shift > 0) && (shift < 5)) {
                    emp.setShift(shift);
                    System.out.println("Record Updated");
                } else {
                    System.out.println("Invalid input");
                }
                break;

            case 5:
                System.out.print("Enter Surgeon emp_no : ");
                no = sc.nextLine();
                surgeonList.get(no).opPatients();
                break;

            case 6:
                System.out.print("Enter Sister emp_no : ");
                no = sc.nextLine();
                sisterList.get(no).visited();
                break;
                
            case 7:
                System.out.print("Enter Employee no : ");
                no = sc.nextLine();
                printEmployeeDetails(no);
                break;

            case 8:
                i = 0;
        }
        return i;
    }

    public static int selectEmp() {
        System.out.println("""
                           
                           
                1. Surgeon
                2. Doctor
                3. Sister
                4. Nurse""");
        int c = sc.nextInt();
        sc.nextLine();
        return c;
    }

    public static int selectShift() {
        System.out.println("""

                           
                Select Shift :
                1. Morning
                2. Noon
                3. Night
                4. Fullday""");
        int c = sc.nextInt();
        sc.nextLine();
        return c;
    }

    public static void selectSpec() {
        int c = 1;
        for (spec myVar : spec.values()) {
            System.out.print(c + ".");
            System.out.println(myVar);
            c++;
        }

        System.out.print("Enter choice : ");
        c = sc.nextInt();
        sc.nextLine();

        switch (c) {
            case 1 -> spec = spec.General;
            case 2 -> spec = spec.Cardiothoracic;
            case 3 -> spec = spec.Neuro;
            case 4 -> spec = spec.Pediatric;
            case 5 -> spec = spec.Plastic;
            case 6 -> spec = spec.Otolaryngology;
        }
    }

    public static void printEmployeeDetails(String empNo) {
        if (surgeonList.containsKey(empNo)) {
            emp = surgeonList.get(empNo);
        } else if (doctorList.containsKey(empNo)) {
            emp = doctorList.get(empNo);
        } else if (sisterList.containsKey(empNo)) {
            emp = sisterList.get(empNo);
        } else if (nurseList.containsKey(empNo)) {
            emp = nurseList.get(empNo);
        } else {
            System.out.println("Employee not found");
            return;
        }

        System.out.println("Employee Details for Employee No " + empNo + ":");
        System.out.println("Name: " + emp.getName());
        System.out.println("Shift: " + emp.getShift());

        if (emp instanceof Surgeon) {
            Surgeon surgeon = (Surgeon) emp;
            System.out.println("SLMC No: " + surgeon.getRegNo());
            System.out.println("Specialization: " + surgeon.getspec());
        } else if (emp instanceof Doctor) {
            Doctor doctor = (Doctor) emp;
            System.out.println("SLMC No: " + doctor.getRegNo());
        } else if (emp instanceof Sister) {
            Sister sister = (Sister) emp;
            System.out.println("Nurse Registration No: " + sister.getRegNo());
        } else if (emp instanceof Nurse) {
            Nurse nurse = (Nurse) emp;
            System.out.println("Nurse Registration No: " + nurse.getRegNo());
        }
    }
}
