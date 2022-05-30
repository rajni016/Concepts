package Assign11P1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorserviceforCollections {
    public static void main(String[]args){
        ExecutorService obj= Executors.newSingleThreadExecutor();
        try {
            List<Callablethreadcollections>thread1=new ArrayList<>();
            thread1.add(new Callablethreadcollections());
            thread1.add(new Callablethreadcollections());
            thread1.add(new Callablethreadcollections());


            Integer result=obj.invokeAny(thread1);
          System.out.println(result);

        }
        catch (Exception e){

        }
        obj.shutdown();
    }
}
