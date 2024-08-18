package Collection;

import java.util.Comparator;
import java.util.TreeSet;
// Inserting numbers in Descending order, default compareTo order is Ascending

public class ComparatorTreeSet {
    public static void main(String[]args){
        TreeSet t=new TreeSet<>(new ComparatorTest());

        t.add(10);
        t.add(0);
        t.add(15);
        t.add(5);
        t.add(20);
        t.add(20);

        System.out.println(t);


    }
}
//o1 is the inserted one(10)
//o2 is the element we are trying to insert
//Customized order is Descending Order
//5, 10-- 10. compared with 5-- 10 has to come first so return -ve(o1>o2)
//20, 10-- 10. compared with 20-- 10 has to come after so return +ve(o1<o2)
class ComparatorTest implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        Integer I1=(Integer) o1;//Inserted object//Casting
        Integer I2=(Integer) o2;// Object that going to be inserted
//        if(I1>I2){
//            return -1;
//        }
//        else if(I1<I2){
//            return +1;
//        }
//        else{
//            return 0;
//        }
// -----------------------------------Alternative Methods
       //return I1.compareTo(I2); // Ascending
        //return -I1.compareTo(I2);// Descending
     return I2.compareTo(I1);// Descending
       // return -I2.compareTo(I1);// Ascending
        // return +1;// Insertion Order
        //return -1;// Reverse of Insertion Order
       // return 0;// only first element

    }


}
// Inserting String Elements in reverse Alphabetical order, default compareTo order is Alphabetical order
class ComparatorStringTreeset {
    public static void main(String[]args){
        TreeSet t=new TreeSet<>(new ComparatorStringTest());

        t.add("Rosy");
        t.add("SuperMan");
        t.add("Rachel");
        t.add("Guitar");
        t.add("Rest");
        t.add("Apple");

        System.out.println(t);


    }
}
class ComparatorStringTest implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
      String S1=(String) o1;//Inserted object//Casting
       String S2=(String) o2;// Object that going to be inserted

        return S2.compareTo(S1);

    }}


//-----------------Stringbuffer elements in Reverse Alphabetical Order

class ComparatorStringBufferTreeset {
    public static void main(String[]args){
        TreeSet t=new TreeSet<>(new ComparatorStringBufferTest());

        t.add(new StringBuffer("Bell"));
        t.add(new StringBuffer("Food"));
        t.add(new StringBuffer("Kettle"));
        t.add(new StringBuffer("Zelle"));
        t.add(new StringBuffer("Axe"));
        t.add(new StringBuffer("Left"));


        System.out.println(t);


    }
}

class ComparatorStringBufferTest implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        String S1=o1.toString();//Inserted object//Casting
        String S2=o2.toString();// Object that going to be inserted

        return S2.compareTo(S1);

    }}