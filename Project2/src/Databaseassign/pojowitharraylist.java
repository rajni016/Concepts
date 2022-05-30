package Databaseassign;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class pojowitharraylist {
    private static Pojoclassconnection o;
    public static void  main(String[]args){
        ArrayList<Pojoclassconnection>obj=new ArrayList<>();
        obj.add(new Pojoclassconnection("test","test@gmail.com","t 2206",0));
        obj.add(new Pojoclassconnection("test1","test1@gmail.com","t1 2206",1));
        obj.add(new Pojoclassconnection("test2","test2@gmail.com","t2 2206",2));
        obj.add(new Pojoclassconnection("test3","test3@gmail.com","t3 2206",3));
        obj.add(new Pojoclassconnection("test4","test4@gmail.com","t4 2206",4));
        obj.add(new Pojoclassconnection("test5","test5@gmail.com","t5 2206",5));
        obj.add(new Pojoclassconnection("test6","test6@gmail.com","t6 2206",6));

            try{
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaimcs", "root", "1234");
                Statement stat = conn.createStatement();
                obj.forEach(o->{

                    try{
                        stat.execute("insert into testdata(number,name,email,mobile)values('"+o.getNumber()+"','"+o.getName()+"','"+o.getEmail()+"','"+o.getMobile()+"')");

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                });
                System.out.println("okay");
;
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e){

        }

        }

    }




