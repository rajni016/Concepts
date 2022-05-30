package Databasemysql;

import java.sql.*;

public class updateandselect {

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaimcs", "root", "1234");

            Statement stmt = conn.createStatement();
            stmt.execute("update customers set city='Hanamkonda',mobile='052206' where cust_name='Java'");
            ResultSet rs = stmt.executeQuery("select * from customers");
            while (rs.next()) {
                System.out.println(rs.getString("cust_name") + "\t" + rs.getString("mobile") + rs.getString("city") + rs.getInt("cust_num"));
            }
            System.out.println("updated hanamkonda");
            stmt.execute("update customers set city='Chennai' where city='chennai'");
            System.out.println("updated chennai");
            ResultSet rs1 = stmt.executeQuery("select * from customers");
            while (rs1.next()) {
                System.out.println(rs1.getString("cust_name") + "\t" + rs1.getString("mobile") + rs1.getString("city") + rs1.getInt("cust_num"));
            }

            System.out.println("updated successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {

        }
    }
}

