package Concepts;

public class ConstructorOverLoading {
    ConstructorOverLoading(String s){
        this(10);

        System.out.println("This is String argument method called directly ");

    }
    ConstructorOverLoading(int i){
        this();

        System.out.println("This is int argument method called using this(10) ");
    }

    ConstructorOverLoading(){
        System.out.println("This is no argument method called using this() instance");
    }
    public static void main(String []args) {
        ConstructorOverLoading obj=new ConstructorOverLoading("Hello");
        ConstructorOverLoading obj1=new ConstructorOverLoading();// This is the reason Inheritance of parent class constructors is not availablefor child.
    }



}

