package Assign8P3;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class ArrayFile {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("HI");
        arr.add("Hello");
        arr.add("Namasthe");
        arr.add("How are you?");
        arr.add("ok ");
        arr.add("HEHHE");
        FileOutputStream obj = null;
        BufferedOutputStream buf = null;


     try {
         obj=new FileOutputStream("Filearray.txt" );
         buf =new BufferedOutputStream(obj);
      for(String arr1:arr){
          buf.write(arr1.getBytes());
          buf.flush();
          System.out.print(arr1);
      }
        }
        catch (IOException E){
           System.out.println("IoError"+E.getMessage());      }
        catch (Exception E){
            System.out.println("Exception" +E.getMessage());
        }
     finally {
         try{
             if(buf!=null){
             buf.close();
             System.out.println("Buffer Connection closed");
         }
             if (obj != null) {
                 obj.close();
                 System.out.println("File Connection closed");
             }
             }
         catch (Exception e){
             System.out.println("Null point Exception"+ e.getMessage());
         }
     }

    }

}
