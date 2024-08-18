package Abstractclass;

public class childclass1 extends parentclass1 {
    @Override
    public void method2() {
        int x=10;
        int result=x+x;
        System.out.println(result);
        System.out.println("A");
    }
    @Override
    public void add(int x, int y) {
        String msg="I'm good";
        int result= x+y;
        System.out.println(result+msg);
    }


    public void childclassmethod (){

        System.out.println("This is child class method");
    }

    public static void main(String[] args) {
          childclass1 obj=new childclass1();
          obj.method2();
          obj.add(5,10);
          parentclass1 objct=new childclass1();
          objct.add(5,55 ,26  );
          //objct.childclassmethod();-- give you error becuase that method belongs to the chil class not parent class(objct is created for parent class)
    }
}



