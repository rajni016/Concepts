package Assign7P1;

import java.util.HashMap;

public class Hashmap {
    public static void main(String[] args) {
        HashMap<String, Long> obj = new HashMap<>();
        obj.put("J", 190L);
        obj.put("A", 90L);
        obj.put("V", 10L);
        obj.put("A", 1009090L);
        obj.put("Good", 199090L);
        System.out.println("Iterating Keys through traditional For loop");
        for (String K : obj.keySet()) {
            System.out.println(K + "\t" + obj.get(K));//Using the key we are getting values
        }
        System.out.println("Iterating Values through traditional For loop");/// Hash map doesnot maintain insertion order.
        for (Long v : obj.values()) {// We can get either keys or values
            System.out.println(v);
        }
        System.out.println("Iterating Key and Values using Lambda");
        obj.forEach((A, B) -> {
            System.out.println(A + "\t" + B);
        });
        System.out.println("Iterating  only  Values using Lambda");
        obj.values().forEach((V) -> {
            System.out.println(V);
        });
        System.out.println("First looping through the key and then for each key we are getting values");
        obj.keySet().forEach((Key) -> {
            System.out.println(Key +"\t"+obj.get(Key));//First looping through the key and then for each key we are getting values;.
        });
    }
}
