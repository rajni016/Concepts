package Collection.ListInterface;

import java.util.Vector;
//Legacy, Lengthy methods and has some special methods like size and Capacity
public class VectorSample {
    public static void main(String[]args){
        Vector v=new Vector<>();// Will have initial capacity 10
        System.out.println(v.capacity());
        for(int i=0;i<10;i++){
            v.addElement(i);
        }
        System.out.println(v.capacity());
        v.addElement("A");
        System.out.println(v.capacity());// After maximum capacity exceeds,new vector object with double the current capacity is created

    }
}
class VectorCapacity{
    public static void main(String[]args){
        Vector obj=new Vector<>(24);// Will have initial capacity 24
        System.out.println(obj.capacity());
        for(int i=0;i<10;i++){
            obj.addElement(i);
        }
        System.out.println(obj.capacity());
        obj.addElement("A");
        System.out.println(obj.capacity());// it didnot exceed max capacity

    }
}
class VectorCapacityDefault{
    public static void main(String[]args){
        Vector obj=new Vector<>(5,2);// Will have initial capacity 5
        System.out.println(obj.capacity());
        for(int i=0;i<5;i++){
            obj.addElement(i);
        }
        System.out.println(obj.capacity());
        obj.addElement("A");// trying to insert, which exceeds max capacity
        //Exceed capacity but new vector object is not created with double size but with the size of specified increment capacity
        System.out.println(obj.capacity());


    }
}