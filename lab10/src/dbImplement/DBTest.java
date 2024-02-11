/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dbImplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest {

    public static void insert(String index_No, String name,String Subject_1,String Subject_2,String Subject_3,float Current_GPA) {
        String sql = "INSERT INTO students(index_No, name, subject_1, subject_2, subject_3, Current_GPA) VALUES(?,?,?,?,?,?)";

        try {
            Connection conn = Connect.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, index_No);
            pstmt.setString(2, name);
            pstmt.setString(3, Subject_1);
            pstmt.setString(4, Subject_2);
            pstmt.setString(5, Subject_3);
            pstmt.setFloat(6, Current_GPA);
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void samples(){
        insert("001", "Samantha Silva", "Mathematics", "Science", "English", (float) 3.5);
insert("002", "Kasun Perera", "History", "Geography", "Sinhala", (float) 3.8);
insert("003", "Nilmini Fernando", "Physics", "Chemistry", "Biology", (float) 3.2);
insert("004", "Rajitha Gunawardena", "Commerce", "Accounting", "Economics", (float) 3.6);
insert("005", "Dilshan Bandara", "Computer Science", "Programming", "Database", (float) 4.0);
insert("006", "Ishara Rajapakse", "English Literature", "Creative Writing", "Grammar", (float) 3.9);
insert("007", "Chaminda Perera", "Art", "Music", "Drama", (float) 3.1);
insert("008", "Kavindi Jayawardena", "Business Studies", "Management", "Marketing", (float) 3.7);
insert("009", "Haritha Mendis", "Physical Education", "Health", "Sports", (float) 3.4);
insert("010", "Tharindu Wijesinghe", "Chemical Engineering", "Thermodynamics", "Material Science", (float) 3.3);
insert("011", "Nisansala Gunathilaka", "Psychology", "Sociology", "Counseling", (float) 3.5);
insert("012", "Chandima Rathnayake", "Political Science", "International Relations", "Public Policy", (float) 3.8);
insert("013", "Indika Kumara", "Environmental Science", "Ecology", "Climate Change", (float) 3.2);
insert("014", "Manel Peris", "Philosophy", "Ethics", "Logic", (float) 3.6);
insert("015", "Nuwan Sampath", "Electrical Engineering", "Circuits", "Digital Systems", (float) 4.0);
insert("016", "Dulani Rajakaruna", "Journalism", "Media Ethics", "News Writing", (float) 3.9);
insert("017", "Kusal Dissanayake", "Mathematical Statistics", "Probability", "Data Analysis", (float) 3.1);
insert("018", "Chathurika Ranasinghe", "Nutrition", "Dietetics", "Food Science", (float) 3.7);
insert("019", "Asanka Fernando", "Civil Engineering", "Structural Analysis", "Construction Management", (float) 3.4);
insert("020", "Shanika Gunasekara", "Dentistry", "Oral Health", "Orthodontics", (float) 3.3);
insert("021", "Roshan Perera", "Information Technology", "Software Development", "Cybersecurity", (float) 3.5);
insert("022", "Ishani Silva", "Tourism Management", "Hospitality", "Event Planning", (float) 3.8);
insert("023", "Thilini Jayasuriya", "Agricultural Science", "Crop Science", "Animal Husbandry", (float) 3.2);
insert("024", "Nimal Wijeratne", "Mechanical Engineering", "Thermodynamics", "Fluid Mechanics", (float) 3.6);
insert("025", "Chamara Peris", "Economics", "Development Economics", "International Trade", (float) 4.0);

    }

    public static void main(String[] args) {
     
        //Retrieve Data
        String sql = "SELECT * FROM employees";

        try {
            Connection conn = Connect.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t"
                        + rs.getString("name") + "\t"
                        + rs.getString("nic"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
