package Concepts.Threads;

public class Thread_Groups  extends Thread{
    //  Constructor
    Thread_Groups(ThreadGroup g, String name){
        super(g,name);
    }
    public void run(){
        System.out.println("Child Thread");
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
class ThreadGroupMain{
    public static void main(String[]args) throws InterruptedException {
        ThreadGroup pg=new ThreadGroup("Parent Group");
        ThreadGroup cg=new ThreadGroup(pg,"Child Group");
        Thread_Groups t1=new Thread_Groups(pg,"Child Thread-1");
        Thread_Groups t2=new Thread_Groups(pg,"Child THread-1");
        t1.start();
        t2.start();
        System.out.println(pg.activeCount());
        System.out.println(pg.activeGroupCount());
        pg.list();
        Thread.sleep(10000);
        System.out.println(pg.activeGroupCount());
        System.out.println(pg.activeCount());
        pg.list();
    }
}

///Getting all the active threads in the System Thread Group
class ThreadGroupSystem{
    public static void main(String[]args) throws InterruptedException {
        ThreadGroup system = Thread.currentThread().getThreadGroup().getParent();
        Thread []t=new Thread[system.activeCount()];
        system.enumerate(t);
        for(Thread t1:t){
            System.out.println(t1.getName()+"---"+t1.isDaemon());
        }
    }

}