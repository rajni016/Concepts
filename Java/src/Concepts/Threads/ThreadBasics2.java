package Concepts.Threads;
// Usually thread class start method will call the run method
//Overriding the start method
//thread class start method will not be called and run method will not be invoked
public class ThreadBasics2 extends Thread{
    @Override
    public void run() {
       System.out.println("This is Thread");
    }

    @Override
    public void start() {
        System.out.println("Over ridden start method will excute the thread as normal class leaving the thread class run method");
    }
    public static void main(String[]args){
        ThreadBasics2 t=new ThreadBasics2();
        t.start();
    }
}

// Super to call thread class start method eventhough we override

class ourstart extends Thread{
    @Override
    public synchronized void start() {

        super.start();
    }
@Override
   public void run(){
        System.out.println("Though we mentioned our start method, super will call thread class start method");
}

    public static void main(String[]args){
       ourstart t=new ourstart();
       t.start();
    }
}



/// We are not over riding the run class
//no output
class Run extends Thread{
    public static void main(String[]args){
        Thread t=new Thread();
        t.start();
    }
}
// Names of Threads
//Assigning our own name to the main class thread
class Namethread extends Thread{
    @Override
    public void run() {
        System.out.println("This is thread created by us"+  Thread.currentThread().getName());// Here current thread is Name thread
    }

    public static void main(String[]args){
        System.out.println(Thread.currentThread().getName());
        Thread.currentThread().setName("My thread");
        System.out.println("THis is main thread executed by "+ Thread.currentThread().getName());// Here current thread is main thread
        Namethread t=new Namethread();
        t.start();
        System.out.println(t.getName());
        t.setName("Thread-0 by me");
        System.out.println(t.getName());
    }

}
class NameThreads extends Thread{
    @Override
    public void run() {
        System.out.println("This is thread created by us"+ ""+ ""+Thread.currentThread().getName());// Here current thread is Name thread
    }

    public static void main(String[]args){

        System.out.println("THis is main thread executed by "+ Thread.currentThread().getName());// Here current thread is main thread
        Namethread t=new Namethread();
        t.start();
        System.out.println("Default priority"+"/"+t.getPriority());
        System.out.println(t.MIN_PRIORITY);
        System.out.println(t.MAX_PRIORITY);
        System.out.println(t.NORM_PRIORITY);
        }

        }
//Priorities of Thread
// Range 1 to 10 , 1 being the lowest and 10 being the highest
class PriorityThreads extends Thread {
    @Override
    public void run() {
        System.out.println("This is Child Thread");
    }

    public static void main(String[] args) {

        System.out.println("Main thread Priority before changing  is " +Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(7);
        Namethread t = new Namethread();
      //  t.start();
        System.out.println("Main thread Priority after changing " +Thread.currentThread().getPriority());
        System.out.println("Child thread priority after changing the main thread priority is " + "" + t.getPriority());


    }
}
//Setting the priority of child thread
//Even though  we set priority of child thread, there is no gurantee that it will execute first because some os donot support priority concepts
class threadpriority extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("This is Child Thread");
        }
    }
    public static void main(String[] args) {
        threadpriority th = new threadpriority();
        th.setPriority(10);
        th.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("This is main thread");
        }


        System.out.println("Main thread Priority is" + Thread.currentThread().getPriority());
        System.out.println("Child thread priority is " + "" + th.getPriority());


    }
}
//Daemon Threads and Non Daemon Treads
//Daemon threads execute in the background and provides support for non Daemon Threads
class Daemonthreads extends Thread {
    @Override
    public void run() {
        System.out.println("This is Child Thread");
    }

    public static void main(String[] args) {

        System.out.println(Thread.currentThread().isDaemon());
        //Thread.currentThread().setDaemon(true);// We cannot change daemon nature of Main Thread
        Daemonthreads t=new Daemonthreads();
        System.out.println(t.isDaemon());
        t.setDaemon(true);
        System.out.println(t.isDaemon());


    }
}

//When last non daemon thread terminates, daemon thread terminates before its completion
//Setting EndNonDaemon thread nature as Daemon, as main thread is non Daemon after its execution, EndNonDaemon will not finish execution
 class EndNonDaemon extends Thread{
    @Override
    public void run() {
        for(int i=0; i<50;i++){
            System.out.println("THis is thread");
        }
    }
    public static void main(String[]args){
        ThreadsBasics t=new ThreadsBasics();
        t.setDaemon(true);// Should set before Starting of main thread
        t.start();

        System.out.println("THis is Main thread");

    }
}