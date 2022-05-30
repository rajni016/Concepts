package Assign11P2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Executorfixed {
    public static void main(String[] args) {
        int processor=Runtime.getRuntime().availableProcessors();
        ExecutorService obj = Executors.newFixedThreadPool(processor);
        try {
            List<Callablethreadprocessor> thread1 = new ArrayList<>();
            thread1.add(new Callablethreadprocessor());
            thread1.add(new Callablethreadprocessor());
            thread1.add(new Callablethreadprocessor());
            thread1.add(new Callablethreadprocessor());
            thread1.add(new Callablethreadprocessor());
            thread1.add(new Callablethreadprocessor());
            thread1.add(new Callablethreadprocessor());
            thread1.add(new Callablethreadprocessor());
            thread1.add(new Callablethreadprocessor());
            thread1.add(new Callablethreadprocessor());
            thread1.add(new Callablethreadprocessor());
            thread1.add(new Callablethreadprocessor());
            obj.invokeAll(thread1);;

        } catch (Exception e) {
            e.printStackTrace();
        }
        obj.shutdown();
    }
}