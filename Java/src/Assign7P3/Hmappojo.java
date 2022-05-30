package Assign7P3;

import Assign7P2.Pojotree;

import java.util.HashMap;//Follows insertion order
import java.util.Optional;

public class Hmappojo {
    public static void main(String[]args){
        HashMap<Integer,Pojohash>obj=new HashMap<>();
        Pojohash hash1= new Pojohash("Java",100);
        obj.put(1,hash1);
        obj.put(2,new Pojohash("Python", 200));
        obj.put(3,new Pojohash("C", 50));
        obj.put(8,new Pojohash("c++", 100));
        obj.put(9,new Pojohash("Spark", 2000));
        System.out.println("values using for loop");// you cannot get both values and keys using for loop
        for(Pojohash itr: obj.values()){
            System.out.println(itr.getId()+"\t"+itr.getName());
        }
        System.out.println("Keys using for loop");
        for(Integer K: obj.keySet()){
            System.out.println(K);
        }
        System.out.println("Values using lambda");
        obj.values().forEach(A->{
            System.out.println(A.getId()+"\t"+A.getName());

        });

        System.out.println("keys using lambda");
        obj.keySet().forEach(key->{
            System.out.println(key);
        });
        System.out.println("keys and values  using  lambda");
        obj.forEach((keys,values)->{
            System.out.println(keys+"\t"+values.getId()+"\t"+values.getName());
        });
        }

    }


