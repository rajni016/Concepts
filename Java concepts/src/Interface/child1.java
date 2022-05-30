package Interface;

public class child1 implements parentclass,parentclass2,parentclass3{
    @Override
    public void add(int x, int y) {
        int result=x-y+x;
        System.out.println(result);
        System.out.println("defintion is created in the child class not the parent class in the interface");
    }

    @Override
    public void strng(String message) {
        String msg="I love you"+ message;
        System.out.println(msg);
        System.out.println("Parent interface class has 3 method so all the methods are overrided where as in abstract " +
                "class only the methods which are mentioned as abstract are overridden and donot have defintions");
    }

    @Override
    public void fl(float a, float b) {
        float some=a+b/a-b;
        System.out.println(some);
        System.out.println("A child can have two parent inerface classes,mutiple inheritance");

    }

    @Override
    public void method1() {
        System.out.println("Can create objects for parent class with help of child class," +
                " this object created can access the methods which are only in that parent class");

    }

    @Override
    public void method2() {
           System.out.println("Now you know interface");
    }
    public static void main(String[]args){
        child1 obj=new child1();
        parentclass objct=new child1();
        parentclass2 class2=new child1();
        obj.add(10,5);
        obj.strng("Pingu kannama");
        obj.fl(10f,5f);
        objct.strng("hehhhe");
        class2.method1();
        class2 .method2();
       // class2.add();__ this method doesnot belongs to parent class2(object is created in the parent class2)
    }

    @Override
    public void method3() {

    }
}
