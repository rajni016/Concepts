package Collection.UtilityClasses;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionsReverseList {
    public static void main(String[]args){
        ArrayList l1=new ArrayList<>();
        l1.add(15);
        l1.add(0);
        l1.add(20);
        l1.add(10);
        l1.add(5);
        System.out.println(l1);
        Collections.reverse(l1);
        System.out.println(l1);
    }
}
