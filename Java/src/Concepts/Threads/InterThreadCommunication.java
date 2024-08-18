package Concepts.Threads;

public class InterThreadCommunication {
}
class threadAdd extends Thread{
    int total=0;

    @Override
    public void run() {
        synchronized (this){
            System.out.println("This is Child Thread before calulaton");
            for(int i=0;i<=100;i++){
                total=total+i;

            }
            System.out.println("Child Thread will notify the main thread");
            this.notify();
        }

    }
}
//Main thread will wait until it gets notification from the threadAdd
class WaitThread{
    public static void main(String[]args) throws InterruptedException {
        threadAdd obj=new threadAdd();
        obj.start();

        synchronized (obj){
         System.out.println("Main Thread calling the wait");
            obj.wait();
            System.out.println("Main thread gets calculation from child thread");
            System.out.println(obj.total);
        }

    }
}
//What if Child Thread gets chance of execution first and Main tHread is in sleep state
// then main thread which is sleeping will never get notification from child thread as in sleep period child thread gave notification
//To avoid this scenario, mention time period in wait method

class WaitThreadSleep{
    public static void main(String[]args) throws InterruptedException {
        threadAdd obj=new threadAdd();
        obj.start();
        Thread.sleep(1000);
        synchronized (obj){
            System.out.println("Main Thread calling the wait");
            obj.wait();
           // obj.wait(100);
            System.out.println("Main thread gets calculation from child thread");
            System.out.println(obj.total);
        }

    }
}