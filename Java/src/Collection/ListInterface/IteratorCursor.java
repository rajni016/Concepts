package Collection.ListInterface;


import java.util.Iterator;
import java.util.Vector;

public class IteratorCursor {
    public static void main(String[]args){
        Vector obj=new Vector<>();
        for(int i=0;i<=10;i++){
            obj.addElement(i);
        }
        System.out.println(obj);
        Iterator itr= obj.iterator();
        //hasMoreElements() and nextElement() are methods of Enumeration
        while(itr.hasNext()){
            Integer I =(Integer)itr.next();
            if(I%2==0){
                System.out.println(I);
            }
            else{
                itr.remove();

            }

        }
        System.out.println(obj);

    }

}
