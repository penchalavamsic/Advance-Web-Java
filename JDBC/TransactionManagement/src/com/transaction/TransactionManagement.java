package com.transaction;
import java.util.*;
import java.sql.*;

public class TransactionManagement {
	public static void main(String[] args) {
        Connection con = null;
        PreparedStatement pstInsert = null;
        PreparedStatement pstUpdate = null;

        try {
            Scanner sc = new Scanner(System.in);

            // 1. Load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Connect
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cdac", "root", "cdac@123");

            // TURN OFF AUTO COMMIT
            con.setAutoCommit(false);

            // ---------- INSERT A NEW STUDENT ----------
            System.out.print("Enter new student name: ");
            String name = sc.nextLine();

            System.out.print("Enter new student GPA: ");
            double gpa = sc.nextDouble();

            pstInsert = con.prepareStatement("INSERT INTO student(name, gpa) VALUES (?, ?)");
            pstInsert.setString(1, name);
            pstInsert.setDouble(2, gpa);
            pstInsert.executeUpdate();


            // ---------- UPDATE ANOTHER STUDENT GPA ----------
            System.out.print("Enter student id to update GPA: ");
            int sid = sc.nextInt();

            System.out.print("Enter new GPA: ");
            double newGpa = sc.nextDouble();

            pstUpdate = con.prepareStatement("UPDATE student SET gpa=? WHERE sid=?");
            pstUpdate.setDouble(1, newGpa);
            pstUpdate.setInt(2, sid);
            pstUpdate.executeUpdate();

            // If no error → COMMIT
            con.commit();
            System.out.println("\nTransaction Successful! All operations committed.");

        } catch (Exception e) {

            // On error → ROLLBACK
            try {
                if (con != null) {
                    con.rollback();
                    System.out.println("\nTransaction Failed! All changes rolled back.");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            e.printStackTrace();

        } finally {
            try {
                if (pstInsert != null) pstInsert.close();
                if (pstUpdate != null) pstUpdate.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
