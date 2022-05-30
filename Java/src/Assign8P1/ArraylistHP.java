package Assign8P1;

import java.util.ArrayList;
import java.util.HashMap;

public class ArraylistHP {
    public static void main(String[] args) {
        ArrayList<HashMap<String, HApojo>> obj = new ArrayList<>();
        HApojo p1 = new HApojo(1234, "Java");
        HashMap<String, HApojo> h1 = new HashMap<>();
        h1.put("Java1", p1);
        HashMap<String, HApojo> h2 = new HashMap<>();
        h2.put("Python1", new HApojo(1200, "python"));
        HashMap<String, HApojo> h3 = new HashMap<>();
        h3.put("C1", new HApojo(2344, "C"));
        obj.add(h1);
        obj.add(h2);
        obj.add(h3);
        /*for (HashMap<String HApojo> itr : obj) {
            for (HApojo ob : itr.values()) {
                System.out.println(ob.getMblenum() + "\t" + ob.getName());
            }

            // System.out.println(itr.keySet()+"\t"+itr.values.getName());
            //}*/
        obj.forEach(o -> {//Loopping through array list
            o.forEach((k, v) -> {// from the array list lloping through the hash map and getting keys and values
                System.out.println(k + "\t" + v.getName() + "\t" + v.getMblenum());
            });


        });
        System.out.println("------");
        obj.forEach(k -> {
            System.out.println(k.keySet()); //This will give you only keys as the values are pojo class.
        });
    }
}

