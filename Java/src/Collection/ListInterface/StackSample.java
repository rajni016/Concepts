package Collection.ListInterface;

import java.util.Stack;

public class StackSample {
    public static void main(String[]args) {
        Stack s = new Stack<>();
        s.push(10);
        s.push(11);
        s.push(12);
        s.push(13);
        s.push(14);
        s.push(15);
        s.push(16);
        s.push(16);
        s.push(16);
        s.push(17);
        s.push(18);
        s.push(19);

        System.out.println(s);
        s.pop();

        s.pop();// removes the element which is top of the stack, i.e., last element
        System.out.println(s);
        System.out.println(s.peek());// Gives element which is on top of stack  i.e., last element
        System.out.println(s.isEmpty());
       System.out.println(s.search(16));// Returns offset value if  present, i.e, position from top of the stack
        System.out.println(s.search(10));
        System.out.println(s.search(20));// Returns -1 if element is not present
        s.addElement(20);//Add element is method of vector, stack is child class of Vector so it is available

    }

}
