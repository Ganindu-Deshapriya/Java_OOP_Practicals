/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labsheet7_2;

/**
 *
 * @author ganin
 */
public class Ward {
    private String name, houseOff, wardNo;
    spec type;
    
    
    public Ward(String name,String no,spec spec){
        this.name = name;
        this.wardNo = no;
        this.type = spec;
    }
    
    public void setHO(String empNo){
        this.houseOff = empNo;
    }
}
