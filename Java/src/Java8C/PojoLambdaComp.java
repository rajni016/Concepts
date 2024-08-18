package Java8C;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PojoLambdaComp {
    String name;
    int num;
    PojoLambdaComp(String name,int num){
        this.name=name;
        this.num=num;
    }
    public String toString(){
        return name+"--"+num;
    }
}
class EmployeeArraylist{
    public static void main(String[]args){
        ArrayList <PojoLambdaComp > l=new ArrayList< >();
        l.add(new PojoLambdaComp("Doctor",112));
        l.add(new PojoLambdaComp("Actor",1));
        l.add(new PojoLambdaComp("Emily",115));
        l.add(new PojoLambdaComp("Fashion",12));
        l.add(new PojoLambdaComp("Letter",102));
        l.add(new PojoLambdaComp("Zone",500));
        System.out.println(l);
        //Sorting Based on the Numbers
        Collections.sort(l,(e1,e2)->(e1.num<e2.num)?-1:(e1.num>e2.num)?+1:0);
        System.out.println(l);
        Collections.sort(l,(e1,e2)->e2.name.compareTo(e1.name));
        System.out.println(l);



    }
}