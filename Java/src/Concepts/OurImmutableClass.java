package Concepts;

public class OurImmutableClass {
    public static void main(String[]args){
       final StringBuffer sb=new StringBuffer("Reference");// Wea are allowed to change content if we declare final
        // but we cannot re assign value to same reference variable
       //sb=new StringBuffer("Variable"); //cannot do this
        sb.append("Variable");
        System.out.println(sb);
        StringBuffer sb1=new StringBuffer("Reassigned");
        System.out.println(sb1);
        sb1=new StringBuffer("ReassignedVariable");
        System.out.println(sb1);




    }
}
final class test{
    private int i;
    test(int i){
        this.i=i;
    }
    public test contentmodify(int i){
        if(this.i==i){
            return this;
        }
        else{
            return new test(i);
        }

    }
    public static void main(String[]args){
        test t1=new test(10);
        test t2=t1.contentmodify(100);
        test t3=t1.contentmodify(10);
        System.out.println(t1==t2);
        System.out.println(t1==t3);

    }
}
