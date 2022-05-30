package Assign9P4;

public class Genericclassbymethod {
    public static void main(String[]args){
        Genericclassbymethod m1=new Genericclassbymethod();
        m1.method1(10);
        m1.method1("Hi");
        m1.method1(100.99d);

    }
    public <A> void method1(A v){
        System.out.println(v);

    }
}
