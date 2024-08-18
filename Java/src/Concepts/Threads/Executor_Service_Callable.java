package Concepts.Threads;

import java.util.concurrent.*;

public class Executor_Service_Callable {
}
//-------------------------------------------------------------------------------
class myThread implements Callable{

    @Override
    public Object call() throws Exception {
       int total=0;
        for(int i=0;i<10;i++){
            total =total+i;

        }
        return total;
        //System.out.println(total);

    }
    public static void main(String[]args) throws ExecutionException, InterruptedException {
        ExecutorService job= Executors.newFixedThreadPool(3);
       Future f= job.submit(new myThread());
       System.out.println(f.get());
       job.shutdown();

    }
}
///------------------------------------------------
class Sumthread implements Callable{
     int num;
     Sumthread (int num){
         this.num=num;
     }
    @Override
    public Object call() throws Exception {
         System.out.println(Thread.currentThread().getName()+"  Isfinding sum of first " +num+"Numbers");
        int sum=0;
        for(int i=0;i<=num;i++){
            sum =sum+i;

        }
        return sum;// this value is held by Future Keyword


    }
    public static void main(String[]args) throws ExecutionException, InterruptedException {
         Sumthread [] array={
                 new Sumthread(10),
                 new Sumthread(20),
                 new Sumthread(30),
                 new Sumthread(40),
                 new Sumthread(50),
                 new Sumthread(60),
                 new Sumthread(70),

         };
        ExecutorService service= Executors.newFixedThreadPool(3);
        for (Sumthread job:array){
            Future f= service.submit(job);// is to hold the return value of callable method of thread
            System.out.println(f.get());// to get the value
        }
        service.shutdown();

    }
}