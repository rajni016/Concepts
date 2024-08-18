package Collection.Set;

import java.util.Comparator;
import java.util.TreeSet;
//---Inserting String and String buffer elements
//Sorting order is increasing length
//If same length Alphabetical Order
public class ComparatorTreeSetHetero {
    public static void main(String[]args){
        TreeSet t=new TreeSet<>(new ComparatorHetero());

        t.add("A");
        t.add(new StringBuffer("ABC"));
        t.add(new StringBuffer("AA"));
        t.add("AA");
        t.add("ABCD");
        t.add("XX");
        t.add("A");


        System.out.println(t);


    }
}
class ComparatorHetero implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        String S1=o1.toString();//Inserted object//Casting
        String S2=o2.toString();// Object that going to be inserted
        int l1=S1.length();
        int l2=S2.length();
        if(l1>l2){
            return +1;
        }
       else if(l1<l2){
            return -1;
        }
       //If same length sort in Alphabetical Order
       else{
            return S1.compareTo(S2);
        }

    }}