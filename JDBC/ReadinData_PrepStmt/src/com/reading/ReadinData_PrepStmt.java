package com.reading;
import java.sql.*;
import java.util.*;

public class ReadinData_PrepStmt {
	public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/cdac";  
        String user = "root";
        String pass = "cdac@123"; 

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);

        try {
            // Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect
            con = DriverManager.getConnection(url, user, pass);

            // Read GPA from user
            System.out.print("Enter GPA value: ");
            float inputGpa = sc.nextFloat();

            // Prepare Query
            String sql = "SELECT sid, name, city, gpa, balance FROM student WHERE gpa < ?";

            pst = con.prepareStatement(sql);
            pst.setFloat(1, inputGpa);

            // Execute Query
            rs = pst.executeQuery();

            System.out.println("\nStudents whose GPA is less than " + inputGpa + ":");

            while (rs.next()) {
                System.out.println("-------------------------------------");
                System.out.println("SID     : " + rs.getInt("sid"));
                System.out.println("Name    : " + rs.getString("name"));
                System.out.println("City    : " + rs.getString("city"));
                System.out.println("GPA     : " + rs.getFloat("gpa"));
                System.out.println("Balance : " + rs.getInt("balance"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cleanup
            try { if (rs != null) rs.close(); } catch (Exception ex) {}
            try { if (pst != null) pst.close(); } catch (Exception ex) {}
            try { if (con != null) con.close(); } catch (Exception ex) {}
            sc.close();
        }
    }
}
