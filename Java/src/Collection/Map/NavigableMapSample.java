package Collection.Map;

import java.util.TreeMap;

public class NavigableMapSample
{
    public static void main(String []args){
        TreeMap <String, String>t=new TreeMap<>();
        t.put("A","Amal");
        t.put("B","Bobby");
        t.put("C","Cat");
        t.put("D","Dinnu");
        t.put("E","Eagle");
        t.put("F","Amal");
        t.put("G",null);
        System.out.println(t);
        System.out.println(t.ceilingKey("C"));
        System.out.println(t.higherKey("C"));
        System.out.println(t.floorKey("C"));
        System.out.println(t.lowerKey("C"));
        System.out.println(t.pollFirstEntry());
        System.out.println(t.pollLastEntry());
        System.out.println(t.descendingKeySet());
        System.out.println(t.descendingMap());
        System.out.println(t);


    }


}
