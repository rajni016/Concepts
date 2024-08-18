package Concepts.Threads;

public class ThreadsBasics extends Thread{
    @Override
    public void run() {
        for(int i=0; i<10;i++){
            System.out.println("THis is thread");
        }
    }
    public static void main(String[]args){
        ThreadsBasics t=new ThreadsBasics();
        t.start();

        System.out.println("THis is Main thread");

    }
}

//Thread using runnable method
//Runnable method has only run method. Runnable thread can be started by passing the object to the thread class and a new thread is created
// Runnable has no start capability
class myrunnable implements Runnable{

    @Override
    public void run() {

        System.out.println("Runnable object is passed to the thread class");
    }
    public static void main(String[]args){
        myrunnable r=new myrunnable();
        Thread t=new Thread(r);// Passing object to the Thread
         t.start();
    }
}
//Recommended approach
//Not passing the Object and Executing the runnable run method
class myrunnabletest implements Runnable{

    @Override
    public void run() {
        System.out.println("Runnable object is not passed to the thread class");
    }
    public static void main(String[]args){
        myrunnable r=new myrunnable();
        Thread t1=new Thread();// This will call the thread run method,which is empty
        Thread t2=new Thread(r);
        t1.start();
        t2.start();
        r.run(); // will execute like normal method no new thread is created

    }
}