package Concepts.Threads;
// If we donot declare methods as synchronised, thread one and threadtwo access same object, so we will get irregular programming
//Try without synchronized
public class ThreadSynchronizationExample2 {
}
class print{
    public synchronized  void printnumbers(){
        for (int i=0;i<10;i++){
            System.out.println(i);
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                System.out.println("I was interrupted while sleeping or waiting");
            }

        }
    }
    public synchronized  void printcharcters(){
        for (int i=65;i<=75;i++){
            System.out.println((char)i);
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                System.out.println("I was interrupted while sleeping or waiting");
            }

        }
    }
}



class threadOne extends Thread {
    print n;

    threadOne(print n) {
        this.n = n;
    }

    @Override
    public void run() {
        n.printnumbers();
    }
}

class threadTwo extends Thread {
    print c;

    threadTwo(print c ) {
        this.c = c;
    }

    @Override
    public void run() {
        c.printcharcters();
    }
}

class mainS{
    public static void main(String[]args){
       print obj=new print();
       threadOne t1=new threadOne(obj);
       threadTwo t2=new threadTwo(obj);
       t1.start();
       t2.start();

    }
}