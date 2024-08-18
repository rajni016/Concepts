package Concepts.Threads;

import java.util.ArrayList;
import java.util.Iterator;

public class ConcurrentModificationExcptn extends Thread {
    static ArrayList l=new ArrayList();
    public void run(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        l.add("S");
    }
    public static void main(String[]args) throws InterruptedException {
        l.add("A");
        l.add("B");
        l.add("C");
        l.add("D");
        ConcurrentModificationExcptn thread= new ConcurrentModificationExcptn();
        thread.start();
        Iterator itr=l.iterator();
        while (itr.hasNext()){
            String s1=(String) itr.next();
            System.out.println("Main Thread Iterating child thread trying to update list");
            Thread.sleep(3000);
        }
        System.out.println(l);
    }
}
