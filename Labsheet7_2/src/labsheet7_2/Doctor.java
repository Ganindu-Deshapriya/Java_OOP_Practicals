
package labsheet7_2;

public class Doctor extends Employee{
    protected String slmcNo;
    
    
    public Doctor(String EmpNo,String EmpName,String regNo){
        this.EmpNo = EmpNo;
        this.EmpName = EmpName;
        this.slmcNo = regNo;
    }
}

