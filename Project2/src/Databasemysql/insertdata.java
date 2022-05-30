package Databasemysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
//select will return result so use executeQuery.
public class insertdata {
    public static void main(String[]args){
        try{
          Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/javaimcs","root","1234");
            Statement stmt=conn.createStatement();
            //stmt.execute("insert into customers(cust_name,mobile,city)values('apachespark','123456','kolkata')");
            stmt.execute("insert into customers(cust_name,mobile,city)values('Java','123456','kolkata')");
            System.out.println("ok");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (Exception e){

        }
    }
}
