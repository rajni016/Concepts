package Concepts;

public abstract class abstractClassesandMethods {

    public void nonAbstractMethod(){
        System.out.println("This is non abstract method");
    }
    public abstract void abstractmethod();

    public static void main(String[] args){

        abstractClassesandMethods parentobject = new childClass();
        parentobject.nonAbstractMethod();
        parentobject.abstractmethod();

    }


}

 class childClass extends abstractClassesandMethods {

    public static void main(String[] args){

        abstractClassesandMethods parentobject = new childClass();
        childClass childobject=new childClass();
        childobject.nonAbstractMethod();

        ///parentobject.nonAbstractMethod();
       // parentobject.abstractmethod();
    }

     @Override
     public void abstractmethod() {
        System.out.println("abstract and non abstract, all methods in the parent class can be called by creating the object for parent class with the help of child class");

     }
 }