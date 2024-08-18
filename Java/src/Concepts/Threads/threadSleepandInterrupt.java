package Concepts.Threads;

public class threadSleepandInterrupt {
    public static void main (String[]args) throws InterruptedException{

        for(int i=0;i<10;i++){
            Thread.sleep(2000);
            System.out.println("Slides");
        }

    }
}
//-----------------------------------------------------------
//Interrupting the Sleeping thread
class interruptthread extends Thread{
    @Override
    public void run() {
        try {
            for(int i=0;i<10;i++){

                System.out.println("Sleeping Thread is interrupted by Interrupt method");

                Thread.sleep(2000);
            }

        } catch (InterruptedException e) {
            System.out.println("Interrupted, got caught in catch");
        }
    }
}
 class SleepInterruptmain {
    public static void main (String[]args) {
         interruptthread t1=new interruptthread();

         t1.start();
         t1.interrupt();


        for(int i=0;i<10;i++){
            System.out.println("Main Thread ");
        }
}
}
//-----------------------------------------------------------
// Interrupt call wasted
//Thread never in sleeping or waking state, interrupt call wasted
class interruptThreadcall extends Thread {
    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {

            System.out.println("interrupt call is wasted");

        }

    }
}
class InterruptWastemain {

    public static void main (String[]args) {
        interruptThreadcall t1=new interruptThreadcall();

        t1.start();
        t1.interrupt();

        for(int i=0;i<10;i++){
            System.out.println("Main Thread ");
        }
    }
}
