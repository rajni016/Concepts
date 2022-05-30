package Assign9P3;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserializationsample {
    public static void main(String[]args){
        System.out.println(Runtime.getRuntime().availableProcessors());
        try{
        FileInputStream fin = new FileInputStream("pojo.txt");
            ObjectInputStream obj2=new ObjectInputStream(fin);
            Serialpojo obj=(Serialpojo) obj2.readObject();
            System.out.println(obj.getId()+obj.getNumber());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception ignored){

        }
    }
}

