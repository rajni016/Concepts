package Collection.Set;

import java.util.TreeSet;

public class TreeSetSample {
    public static void main(String[]args){
        TreeSet t=new TreeSet<>();
       // t.add(null);
        t.add("A");
        t.add("B");
        t.add("a");
        t.add("C");
        t.add("b");
        t.add("Z");
        //t.add(10);//Heterogenous objects are not allowed
       //t.add(null);
        System.out.println(t);// Sorted in Alphabetical order



    }
}
class TreeStringBufferObjects {
    public static void main(String[] args) {
        TreeSet t = new TreeSet<>();
        t.add(new StringBuffer("A"));
        t.add(new StringBuffer("B"));
        t.add(new StringBuffer("L"));
        t.add(new StringBuffer("Z"));
        t.add(new StringBuffer("a"));




        System.out.println(t);// Sorted in Alphabetical order

    }
}
class comparetoMethod {
    public static void main(String[] args) {
         System.out.println("A".compareTo("Z"));// A comes before Z, so negative
        System.out.println("K".compareTo("Z"));//
        System.out.println("Z".compareTo("Z"));
        System.out.println("Z".compareTo("K"));// Z comes after K,so positive,

    }
}