package Assignment6;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
public class Problem4 {
    public static void main(String[]args){
        HashSet<String>Hobj=new HashSet<>();
        Hobj.add("O");
        Hobj.add("R");
        Hobj.add("D");
        Hobj.add("E");
        Hobj.add("R");
        Hobj.add("FOLLOWS NO INSERTION ORDER");
        System.out.println(Hobj);

        LinkedHashSet<Integer>Lobj=new LinkedHashSet<>();
        Lobj.add(10);
        Lobj.add(0);
        Lobj.add(145);
        Lobj.add(8);
        Lobj.add(11);
        System.out.println( Lobj);// Linked hashset will mainatin Insertion order.

        TreeSet<Double>Tobj= new TreeSet<>();
        Tobj.add(10D);
        Tobj.add(0.110D);
        Tobj.add(0D);
        Tobj.add(101.99D);
        Tobj.add(0.001D);
        System.out.println(Tobj);// Arrange the values in ascending order

    }
}
