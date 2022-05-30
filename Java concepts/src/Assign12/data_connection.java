package Assign12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class data_connection {
    /*public static void main(String[]args){
        try{
            //  DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/javaimcs","root","1234");
            Statement state= conn.createStatement();
            state.executeQuery("insert into customers(cust_name,mobile,city)values('spark','23456','kolkata')");
            System.out.println("successful");
        }catch (SQLException S){
            System.out.println("SQL ERROR"+S.getMessage());

        }
        catch (Exception e){
            System.out.println("Error"+e.getMessage());

        }

    }*/
}

