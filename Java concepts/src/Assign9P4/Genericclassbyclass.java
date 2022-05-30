package Assign9P4;

public class Genericclassbyclass {
    public static void main(String[]args){
        Genericsample<String> a1=new Genericsample<String>();
        a1.print("Hi");
        Genericsample<Integer> aint=new Genericsample<>();
        Genericsample<Float> ifloat=new Genericsample<>();
        aint.print(10);
        ifloat.print(10.99f);

    }

}
class Genericsample<A>{
    A val;
    public void print(A v){
        System.out.println(v);
    }
}

