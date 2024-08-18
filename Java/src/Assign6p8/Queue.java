package Assign6p8;

import java.util.PriorityQueue;

public class Queue {
    public static void main(String[]args){
        PriorityQueue<Integer> obj=new PriorityQueue<Integer>();
        obj.add(10);
        obj.add(20);
        obj.add(50);
        obj.add(26);
        System.out.println(obj.peek());
        obj.poll();// poll removes first added element
       // System.out.println(obj.poll());
        obj.add(55);
        obj.add(60);
        obj.add(80);
        obj.offer(299);
        System.out.print(obj);
        System.out.println(obj.element());
        obj.add(15);// numbers are arranged in the ascending order.When 15 is added this becomes first(head) element putting 20 in second place

        System.out.println(obj.element());// peek or element give you first element
        System.out.print(obj);

    }
}
