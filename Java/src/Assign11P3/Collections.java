package Assign11P3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Collections {
    public static void main(String[]args){
        ExecutorService obj= Executors.newCachedThreadPool();
        try{
            List<Thread>thread1=new ArrayList<>();
            thread1.add(new Thread());
            thread1.add(new Thread());
            thread1.add(new Thread());
            thread1.add(new Thread());
            thread1.add(new Thread());
            thread1.add(new Thread());
            thread1.add(new Thread());
            thread1.add(new Thread());
            thread1.add(new Thread());
            obj.invokeAny(thread1);

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        obj.shutdown();
    }
}
