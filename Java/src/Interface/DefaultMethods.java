package Interface;

interface DefaultMethod1 {
    default void method1(){
        System.out.println("This is default method for interface DefaultMethod1");
    }
    static void method2(){
        System.out.println("THis is  static method-2 for interface DefaultMethod1");
    }
}
interface DefaultMethod2{
    default void method1(){
        System.out.println("This is default method for interface DefaultMethod2");
    }
    static void method2(){
        System.out.println("This is static method for interface DefaultMethod2");
    }
}
//It is not mandatory to implement default methods
class childimp implements DefaultMethod1,DefaultMethod2{

    @Override
    public void method1() {
       //DefaultMethod1.super.method1();
        // DefaultMethod2.super.method1();
        System.out.println("This is over-rided method-1 of child class");
    }
    public static void main(String[]args){
        childimp c=new childimp();
        c.method1();
        // Calling Static methods by interface name.
        DefaultMethod2.method2();
        DefaultMethod1.method2();

    }
}
// Static methods can be called only by interface name whether the class is implementing class or not

class normalchild{
    public static void main(String[]args){
        DefaultMethod1.method2();
        DefaultMethod2.method2();

    }
}
