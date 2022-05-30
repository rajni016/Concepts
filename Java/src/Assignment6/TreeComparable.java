package Assignment6;

import java.util.Collections;
import java.util.TreeSet;

public class TreeComparable {
    public static void main(String[] args) {
        TreeSet<PojoComparable> obj = new TreeSet<PojoComparable>();
        obj.add(new PojoComparable("Google", 2000));
        obj.add(new PojoComparable("Microsoft", 100));
        obj.add(new PojoComparable("IBM", 70));
       for (PojoComparable arr:obj){
           System.out.println(arr.getCompName()+ arr.getShareprice() );
       }
    }
}
