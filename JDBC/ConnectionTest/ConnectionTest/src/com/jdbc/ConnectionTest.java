package com.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectionTest {
	public static void main(String args[]) {
		String url="jdbc:mysql://localhost:3306/jdbc";
		String user="root";
		String pass="2002";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//load driver
			Connection con= DriverManager.getConnection(url, user, pass);//connection establish
			Statement st=con.createStatement();
			st.executeUpdate("INSERT INTO student(id, name, cgpa) VALUES(101, 'vamsi', 8.5)");
			System.out.println("Data Inserted Succcessfully");
			con.close();//closing connection
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
