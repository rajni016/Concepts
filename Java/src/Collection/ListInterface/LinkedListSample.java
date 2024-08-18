package Collection.ListInterface;

import java.util.LinkedList;

public class LinkedListSample {
    public static void main(String[]args){
        LinkedList obj =new LinkedList<>();
        obj.add("A");
        obj.add("B");
        obj.add("c");
        obj.add(10);
        obj.add(null);
        obj.add(25);
        obj.add("A");
        obj.add("A");
        obj.add(10);
        System.out.println(obj);
        obj.set(0,"First element");//Replace element of index 0
        obj.add(0,"Again First Element");//Inserted in index 0, already present element is moved to next index
        System.out.println(obj);
        //Execution of stack and Queue using Linked List
        obj.addFirst("First Stack");
        obj.addLast("Last Stack");
        System.out.println(obj);
        obj.removeFirst();
        obj.removeLast();
        System.out.println(obj);


    }
}
