package Collection.ListInterface;

import java.util.Enumeration;
import java.util.Vector;
// Enumeration is cursor used to get elements one  by one from Legacy Class
public class EnumerationCursor {
    public static void main(String[]args){
            Vector obj=new Vector<>();
            for(int i=1;i<=10;i++){
                obj.addElement(i);
            }
            System.out.println(obj);
        Enumeration e= obj.elements();// Elements is method of Vector class
        Enumeration e1=obj.elements();
        //hasMoreElements() and nextElement() are methods of Enumeration
        while(e.hasMoreElements()){
            Integer I =(Integer)e.nextElement();
            if(I%2==0){
                System.out.println(I);
            }
            else{
               System.out.println(I+ "  will be removed");
                obj.remove(I);

            }

        }
        while(e1.hasMoreElements()){
            Integer i=(Integer) e1.nextElement();
            System.out.println(i);
        }

        System.out.println(obj);
        System.out.println(e1.hasMoreElements());

        }

}
