package Concepts.Threads;

// Try without synchronized message method, we will get irregular output

public class ThreadSynchronisation {

}
class message{
    public synchronized  void send(String name){
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
    }
}
class syncThread extends Thread{
    message m;
    String name;
    syncThread(message msg, String cname){
        this.m=msg;
        this.name=cname;
    }

    @Override
    public void run() {
        m.send(name);
    }
}
class Synchmain{
    public static void main(String[]args){
        message m=new message();
        syncThread t1=new syncThread(m,"Java");
        syncThread t2=new syncThread(m,"Python");
        t1.start();
        t2.start();

    }
}
//  For the below case we dont need synchronized method as we are creating two objects m1 and m2 for class message
class Synchmain1{
    public static void main(String[]args){
        message m1=new message();
        message m2=new message();
        syncThread t1=new syncThread(m1,"Java");
        syncThread t2=new syncThread(m2,"Python");
        t1.start();
        t2.start();

    }
}