package Assign10P1;

public class threadsample {
    public static void main(String[]args)  {
        thread th=new thread();
        thread1 th1=new thread1();
        thread2 th2=new thread2();
        th1.start();
        th.start();
        th2.start();
        th2.interrupt();


    }
}
class thread extends Thread{
    @Override
    public void run() {
       System.out.println("This is the first thread created");
    }
}
class thread1 extends Thread {
    @Override
    public void run() {


        for (int j = 0; j < 5; j++) {
            System.out.println(j);
        }
    }

}
class thread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try{
                thread2.sleep(500);

            }
            catch (Exception e){

            }

            System.out.println(i);
        }

    }
}