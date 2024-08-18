package Concepts;

public class constructorConcepts {
    String name;
    int num;
   /* constructorConcepts(String sname, int snum){
        this.name=sname;
        this.num=snum;
    }*/
    public static void main(String [] args){
        constructorConcepts c1=new constructorConcepts();
        System.out.println(c1.name+"...."+c1.num);// output is null, 0 as Java initializes these variable at object creation itself

    }
}
class ConstructorClass {
    String cname;
    String ccollege;
    private ConstructorClass(String sname, String scollege) {
        this.cname=sname;
        this.ccollege=scollege;
    }
    public static void main(String args[]){
        ConstructorClass student1=new ConstructorClass("Student-1","College1");
        ConstructorClass student2=new ConstructorClass("Student-2","College2");
        ConstructorClass student3=new ConstructorClass("Student-3","College3");

        System.out.println(student1.ccollege);
        System.out.println(student2.ccollege);
        System.out.println(student3.ccollege);



    }
}
class ConstructorClassReturn {
    String cname;
    String ccollege;

    public ConstructorClassReturn() {
        System.out.println("Constructor");
    }
  /*  Constructor will execute even when we donot call the constructor
            It will executed automatically when object is created
            WE must get Constructor 3 times in output*/
    public static void main(String []args){
        ConstructorClassReturn obj1=new ConstructorClassReturn();
        ConstructorClassReturn obj2=new ConstructorClassReturn();
        ConstructorClassReturn obj3=new ConstructorClassReturn();
        System.out.println(obj1.ccollege);
        System.out.println(obj2.ccollege);
    }
}

