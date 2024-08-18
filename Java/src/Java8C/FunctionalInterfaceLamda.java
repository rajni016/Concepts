package Java8C;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//Functional Interface consists of only one Abstarct class
//In interface default methods needs to implemented
public interface FunctionalInterfaceLamda {
     void method1();
     default void method2(){
         System.out.println("default methods needs to implemented");
     }

}
//We did not write any method name
//
class lambdainvoke {

    public static void main(String[]args){
        FunctionalInterfaceLamda i=()->System.out.println("This is printed using Lambda Exp");//considered m1 abstract method
        i.method1();
        i.method2();
    }

}
//-----------------------------------------------------------------------------------
// Lambda Expression with Runnable Interface which is Functional INterface as it has single abstact method
class mythread {
    public static void main(String[]args){
        Runnable r=()->{
            for (int i=0;i<10;i++){
                System.out.println("This is Child thread");// Here abstract Method is run()
            }
        };
        Thread t=new Thread(r);
        t.start();
        for (int i=0;i<10;i++){
            System.out.println("This is Main thread");
        }

    }
}
//-----------------------------------------------------------------------------------
// ArrayList Sorting using Comparator FI and Lambda Expressions
class ArraylistLambda{
    public static void main(String[]args){
        ArrayList l=new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(5);
        l.add(20);
        l.add(12);
        Collections.sort(l);// Sorted in Ascending order
        System.out.println(l);
        // No we will Sort in descending order using comparator and Lamda Expression\
        //Implementing the comparator compare methodusing lambda Expressions
        Comparator<Integer> c=(o1,o2)->o1>o2?-1:o1<o2?+1:0;
        Collections.sort(l,c);
        System.out.println(l);
        //Ascending order using Comparator without Lambda Exp
        Collections.sort(l,new compartorsample());
        System.out.println(l);

    }
}
//Without abstract class we need to implement this
class compartorsample implements Comparator<Integer> {


    @Override
    public int compare(Integer o1, Integer o2) {
       if(o1<o2){
           return -1;
       }
      else if(o1>o2){
          return +1;
       }
      else{
          return 0;
       }
    }

}