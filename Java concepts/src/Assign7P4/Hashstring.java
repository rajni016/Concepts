package Assign7P4;

import java.util.ArrayList;
import java.util.HashMap;

public class Hashstring {
    public static void main(String[] args) {
        HashMap<String, ArrayList<Integer>> obj = new HashMap<>();
        ArrayList<Integer> ar1 = new ArrayList<>();
        ar1.add(5);
        ar1.add(7);
        ar1.add(99);
        ar1.add(5);
        ArrayList<Integer> ar2 = new ArrayList<>();
        ar2.add(21);
        ar2.add(20);
        ar2.add(-20);
        ArrayList<Integer> ar3 = new ArrayList<>();
        ar3.add(1);
        obj.put("Position 1", ar1);
        obj.put("Position 10", ar3);
        obj.put("Position 2", ar2);
        System.out.println("Looping  values , for loop");
        for (ArrayList values : obj.values()) {// data type is the arraylist
            System.out.println(values);
        }
        System.out.println("Looping keys , for loop");
        for (String keys : obj.keySet()) {
            System.out.println(keys);
        }
        System.out.println("Looping keys and values with the help of keys , for loop");
        for (String keyswithvalues : obj.keySet()) {
            System.out.println(keyswithvalues + "\t" + obj.get(keyswithvalues));
        }
        System.out.println("keys using lambda");
        obj.keySet().forEach(K -> {
            System.out.println(K);
        });
        System.out.println("Values using lambda");
        obj.values().forEach(V -> {
            System.out.println(V);
        });
        System.out.println("keys and values  using lambda");
        obj.forEach((Keys, Values) -> {
            System.out.println(Keys + "\t" + Values);
        });
        System.out.println("Looping the  values one by one using lambda");
        obj.values().forEach(V -> {
           V.forEach(v->{
               System.out.println(v);
           });
        });

      }
    }


