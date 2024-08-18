package Collection.UtilityClasses;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysSearchUtilityClass {
    public static void main(String[]args) {
        int []  a={10,15,2,11,6};
        Arrays.sort(a);
        for(int a1:a){
            System.out.println(a1);
        }

        System.out.println(Arrays.binarySearch(a,6));// returns Index value
        System.out.println(Arrays.binarySearch(a,14));//returns insertion point


        String []  s={"A","Z","B"};

        Arrays.sort(s);
        for(String s1:s){
            System.out.println(s1);
        }
        System.out.println(Arrays.binarySearch(s,"Z"));// returns Index valu
        System.out.println(Arrays.binarySearch(s,"S"));//returns insertion point


        Arrays.sort(s,new CustomisedArraySearchComparator() );
        for(String s1:s){
            System.out.println(s1);
        }
        System.out.println(Arrays.binarySearch(s,"S",new CustomisedArraySearchComparator()));

    }}

class CustomisedArraySearchComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        String I1=(String) o1;
        String I2=(String) o2;

        return I2.compareTo(I1);
    }
}

