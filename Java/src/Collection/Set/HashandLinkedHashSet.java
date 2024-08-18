package Collection.Set;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class HashandLinkedHashSet {
    public static void main(String[]args){
        HashSet obj=new HashSet<>();
        obj.add("A" );
        obj.add("B" );
        obj.add("c" );
        obj.add("D" );
        obj.add("E" );
        obj.add("F" );
        obj.add(10 );
        obj.add(null);
        obj.add(null);
        System.out.println(obj.add("K"));
        System.out.println(obj.add("K"));// Inserted second time so add() returns Boolean and doesnot give CE or RE
        System.out.println(obj);


    }
}
//Insertion Order is Preserved
class LinkedSet{
    public static void main(String[]args) {
        LinkedHashSet obj=new LinkedHashSet();
        obj.add("A");
        obj.add("B");
        obj.add("c");
        obj.add("D");
        obj.add("E");
        obj.add("F");
        obj.add(10);
        obj.add(null);
        obj.add(null);
        System.out.println(obj.add("K"));
        System.out.println(obj.add("K"));// Inserted second time so add() returns Boolean and doesnot give CE or RE
        System.out.println(obj);

    }
    }
    //Hashset with specifide Initial Capacity Size and Load factor
class HashSetConstructor{
    public static void main(String[]args){
        HashSet obj=new HashSet<>(10,0.90f);
        obj.add("A" );
        obj.add("B" );
        obj.add("c" );
        obj.add("D" );
        obj.add("E" );
        obj.add("F" );
        obj.add(10 );
        obj.add(null);
        obj.add(null);
        System.out.println(obj.add("K"));
        System.out.println(obj.add("K"));// Inserted second time so add() returns Boolean and doesnot give CE or RE
        System.out.println(obj);


    }
}