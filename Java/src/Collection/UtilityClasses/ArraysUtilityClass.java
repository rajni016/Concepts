package Collection.UtilityClasses;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysUtilityClass {
    public static void main(String[]args) {
        int []  a={10,15,2,11,6};
        System.out.println("Primitive array before Sorting");
        for(int a1:a){
            System.out.println(a1);
        }
        System.out.println("Primitive array after Sorting ");
        Arrays.sort(a);
        for(int a1:a){
            System.out.println(a1);
        }

        String []  s={"A","Z","B"};
        System.out.println("Object array before Sorting");
        for(String a2:s){
            System.out.println(a2);
        }
        System.out.println("Primitive array after Sorting");
        Arrays.sort(s);
        for(String a2:s){
            System.out.println(a2);
        }

        System.out.println("Object array after sorting using compartor");

        Arrays.sort(s,new CustomisedArrayComparator());
        for(String a2:s){
            System.out.println(a2);
        }
}}

class CustomisedArrayComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
       String I1=(String) o1;
        String I2=(String) o2;

        return I2.compareTo(I1);
    }
}