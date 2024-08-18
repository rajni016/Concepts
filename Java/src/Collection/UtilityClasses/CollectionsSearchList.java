package Collection.UtilityClasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CollectionsSearchList {
    public static void main(String[]args) {
        ArrayList l = new ArrayList<>();
        l.add("A");
        l.add("k");
        l.add("B");
        l.add("o");
        l.add("D");
        l.add("E");
        System.out.println(l);
        Collections.sort(l);
       System.out.println(Collections.binarySearch(l,"k"));  //As k is present in list it gives index point
        System.out.println(Collections.binarySearch(l,"j"));//As j is absent,it gives insertion point ie., where j can be placed in sorted lis
        ArrayList l1=new ArrayList<>();
        l1.add(15);
        l1.add(0);
        l1.add(20);
        l1.add(10);
        l1.add(5);
        System.out.println(l1);
         Collections.sort(l1,new Customisedclass());
        System.out.println(l1);
        System.out.println(Collections.binarySearch(l1,10,new Customisedclass()));//At search also we need to pass compartor object
        System.out.println (Collections.binarySearch(l1,13,new Customisedclass()));
        System.out.println (Collections.binarySearch(l1,17,new Customisedclass()));
    }}

class Customisedclass implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
       ;
        Integer I1=(Integer) o1;
        Integer I2=(Integer) o2;

        return I2.compareTo(I1);
    }
}