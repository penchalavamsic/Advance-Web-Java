package com.aggregate;
import java.sql.*;

public class AggregateFunctions {
	public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/cdac";
        String user = "root";
        String pass = "cdac@123";

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);

            // -----------------------------------------
            // CHANGE THIS QUERY TO ANY OF THE ABOVE!
            // -----------------------------------------

            String query = 
                "SELECT city, COUNT(*) AS total_customers, SUM(balance) AS total_balance " +
                "FROM customers GROUP BY city HAVING SUM(balance) > 50000";

            pst = con.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                System.out.println(
                    rs.getString("city") + "  |  " +
                    rs.getInt("total_customers") + "  |  " +
                    rs.getInt("total_balance")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
