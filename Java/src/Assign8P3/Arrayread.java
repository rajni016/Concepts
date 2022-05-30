package Assign8P3;

import java.io.*;

public class Arrayread {
    public static void main(String[]args){
        FileInputStream obj1=null;
        BufferedInputStream buf1=null;
        try{
            obj1 =new FileInputStream("Filearray.txt");
           buf1= new BufferedInputStream(obj1);
            int read1 ;
            while((read1=buf1.read()) !=-1) {
             System.out.println((char)read1);
            }
        } catch (FileNotFoundException E){
            System.out.println("File not found"+E.getMessage());
        } catch (IOException E){
            System.out.println("IO"+E.getMessage());

        }
        catch (Exception E){
            System.out.println("Exception"+E.getMessage());
        }
        finally {
            try {
                if(buf1 !=null){
                    buf1.close();
                }
                if (obj1!=null){
                    obj1.close();
                }

            }
            catch (IOException i){
               System.out.println("IO "+i.getMessage());
            }
            catch (Exception e){
                System.out.println("Exception"+e.getMessage());
            }
        }
    }
}
