package Collection.ListInterface;
import java.util.*;
//Duplicates, Null insertion, Insertion order preserved
public class ArrayListsample {
    public static void main(String[]args){
           ArrayList l=new ArrayList<>();
           l.add(10);
           l.add("A");
           l.add("B");
           l.add(null);
           System.out.println(l);
           l.remove(3);
           l.add(2,"C");
           l.add(20);
        System.out.println(l);
    }

}
