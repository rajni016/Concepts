package Abstractclass;

public abstract class parentclass1 {

    public static void method1() {

        System.out.println("only the methods which are declared as abstract class are defined in child class");
    }
    public static void add(int x, int y,int z){
        int edookati =x+y-z-x-y+z;
    }
    public abstract void method2();
    public abstract void add(int x, int y) ;
}
