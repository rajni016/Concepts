package Databasemysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Deletedata {
    public static void main(String[]args){
        try{
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/javaimcs","root","1234");
            Statement stmt= conn.createStatement();
            stmt.execute("delete from customers where city='hyd'");
            System.out.println("Deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e){

        }
    }
}
