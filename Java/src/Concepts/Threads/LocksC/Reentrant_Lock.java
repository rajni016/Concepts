package Concepts.Threads.LocksC;

import java.util.concurrent.locks.ReentrantLock;

public class Reentrant_Lock {
}
class display1{
    ReentrantLock l=new ReentrantLock();
    public void send(String name){

        l.lock();
        for (int i=0;i<10;i++){
            System.out.print("Welcome to Synchronised Concept:");
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                System.out.println("I was interrupted while sleeping or waiting");
            }
            System.out.println(name);
        }
        l.unlock();
    }
}
class Thread_Wish extends Thread{
    display1 d;
    String name;
    Thread_Wish(display1 d, String cname){
        this.d=d;
        this.name=cname;
    }

    @Override
    public void run() {
        d.send(name);
    }
}
class Lockmian{
    public static void main(String[]args){
        display1 d=new display1();
        Thread_Wish t1=new Thread_Wish(d,"Java");
        Thread_Wish t2=new Thread_Wish(d,"Python");
        t1.start();
        t2.start();

    }
}
