package Concepts.Threads.LocksC;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockTime {
}

class ThreadtryWithTime extends Thread{
    static ReentrantLock l=new ReentrantLock();
    ThreadtryWithTime( String name){
        super(name);
    }

    @Override
    public void run() {
        do{
            try {
                if(l.tryLock(5000, TimeUnit.MILLISECONDS)){
                    System.out.println(Thread.currentThread().getName()+"Got Lock ");
                    Thread.sleep(30000);
                    l.unlock();
                    System.out.println(Thread.currentThread().getName()+"Releases the lock ");
                    break;
                }
                else{
                    System.out.println(Thread.currentThread().getName()+"Unable to get lock and will try lock ");
                }
            }
            catch (InterruptedException e){
                System.out.println("I was interrupted while sleeping or waiting");
            }

        }
        while(true);// Will go on till it becomes true

    }

}
class tryLockTimeMain{
    public static void main(String[]args){
        ThreadtryWithTime t1=new ThreadtryWithTime("Thread-1");
        ThreadtryWithTime t2=new ThreadtryWithTime("Thread-2");
        t1.start();
        t2.start();

    }
}
