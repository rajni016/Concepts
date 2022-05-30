package Assign9P2;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class Bytearrayoutputstreamproblem {
    public static void main(String []args){
        ArrayList<String>obj=new ArrayList<>();
        obj.add("Hi");
        obj.add("Hello");
        obj.add("Namaste");
        obj.add("How are you?");
        obj.forEach(o->{
            System.out.println(o);
            try {
                FileOutputStream  f=new FileOutputStream("o.txt");
                FileOutputStream f1=new FileOutputStream("o1.txt");
              ByteArrayOutputStream bos=new ByteArrayOutputStream();
              bos.write(o.getBytes());
              bos.writeTo(f);
              bos.writeTo(f1);


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            catch (Exception e){

            }
        });

    }
}
