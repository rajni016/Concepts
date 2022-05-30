package Assign6p8;
import java.util.Stack;
public class Stack1 {
    public static void main(String[]args){
        Stack<Double>objstack=new Stack<Double>();
        objstack.add(0.067D);
        objstack.add(990.909D);
        objstack.add(456D);
        objstack.add(.67D);
      //
        System.out.print(objstack.peek());// will get last element
        System.out.print(objstack+"\t");
        System.out.print(objstack.pop());// removed last element
        System.out.print(objstack);
        objstack.add(500D) ;
        objstack.add(199D);
        objstack.add(189D);
        objstack.add(169D);
        System.out.print(objstack);
        System.out.print(objstack.peek());/// last added element is the last element.

    }
}
