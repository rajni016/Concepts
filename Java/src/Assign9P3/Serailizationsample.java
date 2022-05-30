package Assign9P3;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serailizationsample {
    public static void main(String[]args){
        Serialpojo obj=new Serialpojo();
        obj.setId(1);
        obj.setNumber(200);
       //obj.getMessgae("hi");
        try {
            FileOutputStream f=new FileOutputStream("pojo.txt");
            ObjectOutputStream obj1=new ObjectOutputStream(f);
            obj1.writeObject(obj);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
