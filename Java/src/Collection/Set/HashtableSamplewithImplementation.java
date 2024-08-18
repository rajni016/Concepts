package Collection.Set;

import java.util.Hashtable;

public class HashtableSamplewithImplementation {
    public static void main(String []args){

        Hashtable t=new Hashtable<>();
        t.put(new defaultclass(5),"A");
        t.put(new defaultclass(2),"B");
        t.put(new defaultclass(6),"C");
        t.put(new defaultclass(15),"D");
        t.put(new defaultclass(23),"E");
        t.put(new defaultclass(16),"F");
        System.out.println(t);

        //
        Hashtable t1=new Hashtable<>(23);
        t1.put(new defaultclass(5),"A");
        t1.put(new defaultclass(2),"B");
        t1.put(new defaultclass(6),"C");
        t1.put(new defaultclass(15),"D");
        t1.put(new defaultclass(23),"E");
        t1.put(new defaultclass(16),"F");
        System.out.println(t1);



    }
}

class defaultclass{
    int i;
    defaultclass(int i){
        this.i=i;
    }
    public int hashCode(){
     return i;
     //   return i%9;
    }
    public String toString(){
        return i+"";
    }

}