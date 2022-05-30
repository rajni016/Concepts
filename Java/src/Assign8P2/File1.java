package Assign8P2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class File1 {
    public static void main(String[]args)  {
        FileOutputStream obj= null;
        try{
            obj=new FileOutputStream("Assign7.txt");
            String message= "ASSIGNMENT-7 SECOND PROBLEM";
            obj.write(message.getBytes());
        }
        catch (IOException I){
            System.out.println(I.getMessage());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            try{
                obj.close();
            }
            catch (Exception e){
                System.out.println("Close Error"+ e.getMessage());

            }
        }

        }
    }

