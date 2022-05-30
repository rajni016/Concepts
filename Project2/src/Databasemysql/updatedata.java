package Databasemysql;


import java.sql.*;


public class updatedata {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaimcs", "root", "1234");

            Statement stmt=conn.createStatement();
          stmt.execute("update customers set city='Hanamkonda',mobile='o52206' where cust_name='Java'");
            stmt.execute("update customers set city='Cchennai' where city='Chennai'");
           ResultSet rs=stmt.executeQuery("select * from customers");
           while(rs.next()){
               System.out.println(rs.getString("cust_name")+"\t"+rs.getString("mobile")+rs.getString("city")+rs.getInt("cust_num"));
         }
            System.out.println("updated");
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e){

        }
    }
}