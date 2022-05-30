package Assign10P2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class callableexecutorsthread_pool {
    public static void main(String[]args){
        ExecutorService obj1= Executors.newSingleThreadExecutor();

        try {
            Future<Integer> obj2=obj1.submit(new callthread());
            System.out.println(obj2.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
    }

