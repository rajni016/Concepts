package Assign8P2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Watchable;

public class Fileread {
    public static void main(String[]args) throws FileNotFoundException {
              FileInputStream inp=null;

        try{
            inp= new FileInputStream("Assign7.txt");
            System.out.println((char) inp.read());
            int read;
            while ((read=inp.read())!=-1){
                System.out.print((char)read);

            }
        }
        catch (FileNotFoundException e){
            System.out.println("FIle not found" + e.getMessage());
        }
        catch (IOException I){
            System.out.println("IO exception"+I.getMessage());
        }
        catch (Exception E){
            System.out.println("Error : "+ E.getMessage());
        }
        finally {
            try {
                inp.close();

            }
            catch (Exception e){
                System.out.println("Close error"+ e.getMessage());
            }
        }

    }
}
