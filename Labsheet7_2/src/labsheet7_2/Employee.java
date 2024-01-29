/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labsheet7_2;

/**
 *
 * @author ganin
 */
public class Employee {
    protected String EmpName;
    protected String EmpNo;
    private int Shift;

    /**
     * @return the EmpName
     */
        
     public String getName() {
        return EmpName;
    }

    public String getRegNo() {
        return EmpNo;
    }

    /**
     * @return the Shift
     */
    public int getShift() {
        return Shift;
    }

    /**
     * @param Shift the Shift to set
     */
    public void setShift(int Shift) {
        this.Shift = Shift;
    }
}



