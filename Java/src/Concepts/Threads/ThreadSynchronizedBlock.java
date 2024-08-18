package Concepts.Threads;

public class ThreadSynchronizedBlock {
}
//Instead of Declaring whole method as synchronised we declare certain block as synchronised
class viewmessage{
    public void send(String name){
        synchronized (viewmessage.class){
            System.out.println("Synchronised block with class level: for whole class view message ");
        }
        //Object level lock, when we create two objects, we donot need synchronised block
        //Only for method send
    synchronized (this)  {
         for (int i=0;i<10;i++){
             System.out.println("Welcome to Synchronised Concept:");
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
}
class Threadmessage extends Thread{
    viewmessage v;
    String name;
    Threadmessage(viewmessage msg, String cname){
        this.v=msg;
        this.name=cname;
    }

    @Override
    public void run() {
      v.send(name);
    }
}
class Syncmain{
    public static void main(String[]args){
        viewmessage obj=new viewmessage();
        Threadmessage t1=new Threadmessage(obj,"Java");
        Threadmessage t2=new Threadmessage(obj,"Python");
        t1.start();
        t2.start();

    }
}