package Concepts.Threads;
//Remove Synchronised keeyword to avoid dead lock, atleast remove on one method
public class ThreadDeadLock {
}
class A{
    public synchronized void d1(B b){
        System.out.println("THis is Class A");
        //We are making Thread sleep so that Other thread gets chance but never executes as this thread is holding the lock
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        b.last();
    }
    public synchronized void last(){
        System.out.println("This is last method of Class-A");
    }

}

class B {
    public synchronized void d2(A a){
        System.out.println("Thread2 starts execution of d1() method");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a.last();
    }

    public synchronized void last(){
        System.out.println("This is last method of Class-B");
    }

}
class Deadlock extends Thread{
        A a=new A();
        B b=new B();
        public void m1(){
            this.start();
            a.d1(b);
        }
        public void run(){
            b.d2(a);
        }
        public static void main(String[]args){
            Deadlock t=new Deadlock();
            t.m1();
        }
}