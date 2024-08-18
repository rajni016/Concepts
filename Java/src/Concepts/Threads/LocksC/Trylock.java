package Concepts.Threads.LocksC;

import java.util.concurrent.locks.ReentrantLock;

public class Trylock {
}

class Threadtry extends Thread{
    static  ReentrantLock l=new ReentrantLock();
   Threadtry( String name){
       super(name);
    }

    @Override
    public void run() {
      if(l.tryLock()){
          System.out.println(Thread.currentThread().getName()+"Got Lock and exceuting the if condition");
          try {
              Thread.sleep(1000);
          }
          catch (InterruptedException e){
              System.out.println("I was interrupted while sleeping or waiting");
          }
          l.unlock();
      }

      else{
          System.out.println(Thread.currentThread().getName()+"Did not get Lock instead of waiting executing the else condition");
      }
    }
}
class tryLockMain{
    public static void main(String[]args){
        Threadtry t1=new Threadtry("Thread-1");
       Threadtry t2=new Threadtry("Thread-2");
        t1.start();
        t2.start();

    }
}

