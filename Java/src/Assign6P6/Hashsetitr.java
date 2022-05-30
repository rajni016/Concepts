package Assign6P6;

import java.util.HashSet;

public class Hashsetitr {
    public static void main(String[] args) {
        HashSet<Hashpojo> obj = new HashSet<Hashpojo>();
        obj.add(new Hashpojo("ITR116", "March"));
        obj.add(new Hashpojo("ITR110", "April"));
        obj.add(new Hashpojo("ITR118", "May"));
        obj.add(new Hashpojo("ITR117", "March"));
        obj.add(new Hashpojo("ITR114", "Jan"));
        obj.add(new Hashpojo("ITR113", "May"));
      // obj.stream().filter((o)->o.getName()).forEach((o)->{
           // System.out.println(o.getBatchmonth());
        for(Hashpojo x:obj) {
               System.out.println(x.getBatchmonth()+"\t"+x.getName());
        }
    }
}