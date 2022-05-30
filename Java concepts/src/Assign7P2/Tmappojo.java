package Assign7P2;

import java.util.TreeMap;// will sort the data in ascending order based on the key

public class Tmappojo {
    public static void main(String[]args){
        TreeMap<Integer, Pojotree>obj= new TreeMap<>();
        Pojotree class1= new Pojotree(100, "A");
        obj.put(1, new Pojotree(100,"A"));
        obj.put(2, new Pojotree(99,"A"));
        obj.put(3, new Pojotree(97,"A"));
        obj.put(4, new Pojotree(80,"B"));
        obj.put(5, new Pojotree(100,"A"));
        obj.put(6, new Pojotree(80,"A"));
        obj.put(7, new Pojotree(35,"Fail"));
        System.out.println("Looping keys , for loop");
        for(Integer k:obj.keySet()){
            System.out.println(k);
        }
        System.out.println("Looping  values, for loop");
        for(Pojotree v: obj.values()){
            System.out.println( v.getMarks()+"\t"+v.getGrade());
        }
        System.out.println("Looping keys , for loop");
        for (Integer key:obj.keySet()){
            System.out.println(key);
        }
        System.out.println("Looping through values and getting keys from it");
        obj.values().forEach(v->{
            System.out.println(v.getMarks()+"\t"+v.getGrade());
                }
                );
        System.out.println("Looping both keys and values");
        obj.forEach((A,B) ->{
            System.out.println(A + "\t" +B.getMarks()+ "\t" +B.getGrade());// As values are from pojo class we need get method
        }
            );
        System.out.println("Looping through keys");
        obj.keySet().forEach(k->{
            System.out.println(k);// As keys are directly from the treemap , no get method
        });
    }
}
