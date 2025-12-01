package com.batchprocessing;
import java.sql.*;
public class BatchProcess {
	 public static void main(String[] args) {

	        String url = "jdbc:mysql://localhost:3306/cdac";
	        String username = "root";
	        String password = "cdac@123"; 

	        Connection con = null;
	        Statement stmt = null;

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection(url, username, password);

	            // Disable auto-commit for batch processing
	            con.setAutoCommit(false);

	            stmt = con.createStatement();

	            // -------------------------
	            // a. Update balance +10000 where city is Hyd or Pune
	            // -------------------------
	            stmt.addBatch(
	                "UPDATE customers SET balance = balance + 10000 WHERE city IN ('Hyd', 'Pune')"
	            );

	            // -------------------------
	            // b. Delete customers where balance < 50000
	            // -------------------------
	            stmt.addBatch(
	                "DELETE FROM customers WHERE balance < 50000"
	            );

	            // -------------------------
	            // c. Insert 1st new customer
	            // -------------------------
	            stmt.addBatch(
	                "INSERT INTO customers (name, city, item, price, balance) " +
	                "VALUES ('Ravi', 'Hyd', 'Guava', 120, 60000)"
	            );

	            // -------------------------
	            // d. Insert 2nd new customer
	            // -------------------------
	            stmt.addBatch(
	                "INSERT INTO customers (name, city, item, price, balance) " +
	                "VALUES ('Deepa', 'Pune', 'Kiwi', 180, 75000)"
	            );

	            // -------------------------
	            // e. Update balance +15000 where cid between 3000 and 7000
	            // -------------------------
	            stmt.addBatch(
	                "UPDATE customers SET balance = balance + 15000 WHERE cid BETWEEN 3000 AND 7000"
	            );

	            // Execute the batch
	            int[] results = stmt.executeBatch();

	            // Commit all changes
	            con.commit();

	            System.out.println("Batch Processing Completed Successfully!");
	            for (int i = 0; i < results.length; i++) {
	                System.out.println("Operation " + (i + 1) + " -> " + results[i]);
	            }

	        } catch (Exception e) {
	            try {
	                if (con != null) {
	                    System.out.println("Error occurred! Rolling back...");
	                    con.rollback();
	                }
	            } catch (Exception ex) {
	                ex.printStackTrace();
	            }
	            e.printStackTrace();
	        } finally {
	            try { if (stmt != null) stmt.close(); } catch (Exception ex) {}
	            try { if (con != null) con.close(); } catch (Exception ex) {}
	        }
	    }
}
