package Concepts.Threads;

import java.util.concurrent.*;

public class Executor_Service_Runnable {
}
class PrintingJob implements Runnable{
    String name;
    PrintingJob(String name){
        this.name=name;

    }
    @Override
    public void run() {
        System.out.println(name+ "  Job Started by  "+Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out .println(name+"  Job Finished by "+Thread.currentThread().getName());

    }


}
class Executormain{
    public static void main(String[]args){
        PrintingJob [] jobs={
                new PrintingJob("Java"),
                new PrintingJob("Python"),
                new PrintingJob("C"),
                new PrintingJob("C++"),
                new PrintingJob("JavaScript"),
                new PrintingJob("PHP"),

        };
        ExecutorService service=Executors.newFixedThreadPool(3);
        //3 threads responsible for execute 6 jobs so that a single thread is reused for multiple jobs

        for (PrintingJob j:jobs){
            service.submit(j);
        }
        service.shutdown();

    }
}