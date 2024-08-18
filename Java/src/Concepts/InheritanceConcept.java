package Concepts;



public  class InheritanceConcept  {

    String s="Parent";
    public void method1(){
        System.out.println("This is method-1 from the parent class");
    }
    public void method2(){
        System.out.println("This is method-2 from the parent class");
    }
    public Number method3(int x, float y){
       Number result =x+y;
       return result;
    }
    private void pvtmethod(){
        System.out.println("This method is not visible for child class");
    }
    public final void fnlmethod(){
        System.out.println("This is final method cannot be overridden in the child class");

    }
   void increaseScope (){
        System.out.println("Method from parent class, (default) scope is increased in child class by over ridden method");
    }
     static void methodHiding (){
        System.out.println("As I'm Static method,my child class method is hidden, and I will be called as Compiler takes care of Method Signature Not Jvm in my static case");

    }


}

