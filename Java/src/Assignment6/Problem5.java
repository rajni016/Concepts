package Assignment6;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class Problem5 {
    public static void main(String[]args){
        LinkedHashSet<Long>obj=new LinkedHashSet<Long>();
        obj.add(3900000L );
        obj.add(5000000L );
        obj.add(1000L );
        obj.add(23000L );
        obj.add(8000L );
        obj.add(19000L );
        for(Long arr:obj){
            System.out.println(arr);
        }
    }

}
