package Assignment5;
import java.util.ArrayList;
import java.util.Collections;

public class Problem3 {
    public static void main(String[]args){
        ArrayList<Long>a=new ArrayList<Long>();
        a.add(8500L);
        a.add(39000L);
        a.add(45L);
        for(Long arr:a){
            System.out.println(arr);
        }
       Collections.sort(a);
       System.out.println(a);
       ArrayList<Long>b=new ArrayList<Long>();
       a.add(5000L);
       a.add(60000L);
       a.add(7890L);
       a.addAll(b);
       System.out.println(a);
    }
}
