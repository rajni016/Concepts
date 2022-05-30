package Databasemysql;

import java.sql.*;

public class selectdata {
    //for selection we need to use executeQuery, for insert delete,update execute
    public static void main(String[] args) {

        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/javaimcs", "root", "1234");
            Statement stmt = conn.createStatement();

            ResultSet rs= stmt.executeQuery("select cust_num,cust_name,mobile from customers where cust_num=1");

            while(rs.next()) {
                System.out.println(rs.getString("mobile")+rs.getString("cust_name"));
            }
            System.out.println("ok..");
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
