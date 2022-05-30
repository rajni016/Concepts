package Assign8P4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Fileexistsornot {
    public static void main(String[] args) throws IOException {
        FileOutputStream obj = null;
        File Fil = null;
        String message = "Using File.exist we created this file";
        try {
            Fil = new File("Assign7.txt");
            if ((Fil.exists())) {
                System.out.println("File exists");

            } else {

                obj = new FileOutputStream("Assign5.txt");
                {
                    obj.write(message.getBytes());
                    System.out.println("File Created");
                }
            }


        } catch (IOException E) {
            System.out.println(E.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (obj != null) {
                    obj.close();
                    System.out.println("Obj is not null");

                }
                else{
                    System.out.println("Obj is  null");
                }

            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
