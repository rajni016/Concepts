package Collection.UtilityClasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CollectionsSortList {
    public static void main(String[]args){
        ArrayList l=new ArrayList<>();
        l.add("A");
        l.add("k");
        l.add("B");
        l.add("o");
        l.add("D");
        l.add("E");
        System.out.println(l);
       // Collections.sort(l);
       Collections.sort(l,new CustomisedSortingByComparator());
        System.out.println(l);

        ///L1 is homogenous and no null values as we are sorting it
        ArrayList l1=new ArrayList<>();
        l1.add(10);
        l1.add(20);
        l1.add(30);
        l1.add(0);
        l1.add(-10);
        l1.add(4);

        Collections.sort(l1);// Sorted in Ascending
        //System.out.println(l1);
    }
}
//Customised Sorting, Descending Order
class CustomisedSortingByComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        String s1=(String) o1;
        String s2=(String) o2;

        return s2.compareTo(s1);
    }
}