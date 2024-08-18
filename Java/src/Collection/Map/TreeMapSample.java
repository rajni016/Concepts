package Collection.Map;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapSample {
    public static void main(String []args){
        TreeMap t=new TreeMap<>();
        t.put(101,"A");
        t.put(102,"b");
        t.put(103,"C");
        t.put(104,"D");
        t.put(105,"E");
        t.put(107,"A");
        t.put(108,null);
       // t.put(null,"Null"); NUll pointer Exception
        System.out.println(t);

    }
}
class customisedsorting {
    public static void main(String[]args){
        TreeMap ct=new TreeMap<>(new treeComparator());
        ct.put(101,"AA");
        ct.put(102,"bvb");
        ct.put(103,"CC");
        ct.put(104,"D");
        ct.put(105,"aa");
        System.out.println(ct);


    }


}
class treeComparator implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        Integer i1=(Integer) o1;
        Integer i2=(Integer) o2;
        return i2.compareTo(i1);
    }
}