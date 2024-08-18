package Concepts.Threads;
// Child Thred yields and Main thread will  finish the process first
public class ThreadYield extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Child Thread");
            Thread.yield();
        }
    }
}
class yieldthread{
    public static void main(String[]args){
        ThreadYield th=new ThreadYield();
        th.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("Main Thread");
            Thread.yield();
        }

    }
}
//---------------------------------------------------------------------------------------

