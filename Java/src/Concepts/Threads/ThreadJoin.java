package Concepts.Threads;

public class ThreadJoin implements Runnable {

    @Override
    public void run() {
        for (int i=0;i<10;i++){
            System.out.println("This is Thread-1");
            try{
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
class thread2 implements Runnable{

    @Override
    public void run() {
        for (int i=0;i<5;i++){
            System.out.println("This is Thread-2 which wait until Thread-1 finishes");

        }


    }
}

// Main thread and thread-2 will wait until Thread-1 finishes

class mainclass {
    public static void main(String[]args) throws InterruptedException {
              ThreadJoin r1=new ThreadJoin();
              Thread t1=new Thread(r1);
              t1.start();
              t1.join();// All the  threads will wait until Thread-1 finishes
             thread2 r2=new thread2();
             Thread t2=new Thread(r2);
             t2.start();

        for (int i=0;i<5;i++){
            System.out.println("This is main thread executes only after finishing thread-1");
        }
    }
}
//-------------------------------------------------------------------------------------------------------------------
//Main thread will wait only for 0.5 seconds to finish Thread-1 Execution
class mainclasswait {
    public static void main(String[]args) throws InterruptedException {
        ThreadJoin r1=new ThreadJoin();
        Thread t1=new Thread(r1);
        t1.start();
        t1.join(50);// All the  threads will wait until only for 500 mseconds
        //thread2 r2=new thread2();
       // Thread t2=new Thread(r2);
       // t2.start();

        for (int i=0;i<5;i++){
            System.out.println("This is main thread executes after waiting of  0.5 s for finishing thread-1");
        }
    }
}
//-------------------------------------------------------------------------------------------------------------------
//Applying join on main thread, main thread donot have reference-type and object
//Child thread calls join method on main thread object, so child thread has to wait until main thread completes
class thread3 extends Thread{
    static Thread mainobj;
    @Override
    public void run() {
        try {
            mainobj.join();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        for (int i=0;i<5;i++){
            System.out.println("This is Thread-3 which wait until main thread finishes");



        }


    }
}
class mainobj{
    public static void main(String[]args){
        thread3.mainobj=Thread.currentThread();//We are referencing thread object to the main thread
        thread3 t3=new thread3();
        t3.start();

        for (int i=0;i<10;i++){
            System.out.println("This is Main Thread");
            try{
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
//------------------------------------------------------------------------------------------
//DEAD LOCK SITUATION
// Child Thread calling join method on Main Thread object and Main Thread Calling Child Thread on Main Thread Object
// Both threads will wait Forever

class threadDead extends Thread{
    static Thread obj;
    @Override
    public void run() {
        try {
            obj.join();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        for (int i=0;i<5;i++){
            System.out.println("This is Thread-3 which wait until main thread finishes");



        }


    }
}
class mainDead{
    public static void main(String[]args) throws InterruptedException {
        threadDead.obj=Thread.currentThread();//We are referencing thread object to the main thread
        threadDead th=new threadDead();
        th.start();
        th.join();

        for (int i=0;i<10;i++){
            System.out.println("This is Main Thread");
            try{
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

//------------------------------------------------------------------------------------------
// DEAD LOCK SITUATION EXAMPLE-2
class mainDead2{
    public static void main(String[]args) throws InterruptedException {
        Thread.currentThread().join();//


        for (int i=0;i<10;i++){
            System.out.println("This is Main Thread");
            try{
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}