package Collection.Map;

import java.util.*;

public class HashMapSample {

    public static void main(String[]args){
        HashMap m=new HashMap<>();
        m.put("A",100);
        m.put("B",200);
        m.put("C",120);
        m.put("D",145);
        m.put("F","Easy");
        m.put("E","Easy");
        m.put(200,12);
        System.out.println(m);
        System.out.println(  m.put("A",-4000));// Replacing the value
        //Collection Views ofMap
        Set key=m.keySet();
        Collection c=m.values();
        Set entryv=m.entrySet();
        System.out.println("Set of Keys in a set, unique keys   "+ key);
        System.out.println("Set of Values in collection,  yes to duplicates  "+c);
        System.out.println("Set of key and values as set, unique, so set  "+entryv);
//Getting the objects one-by one using Iterator
// Entry(I) which is inner interface of MAp(i) has methods getKey, getValue, setKey

        Iterator itr=entryv.iterator();
        while(itr.hasNext()) {
            Map.Entry m1=(Map.Entry)itr.next();
            System.out.println(m1.getKey()+"---"+m1.getValue());
            if(m1.getKey().equals("A")){
                m1.setValue("Value changed");

            }

        }
        System.out.println(m);



    }
}
