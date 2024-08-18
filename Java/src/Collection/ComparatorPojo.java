package Collection;

import java.util.Comparator;
import java.util.TreeSet;

public class ComparatorPojo {
}
class employee implements Comparable{

    String name;
    int id;
    employee(String name, int id){
        this.name=name;
        this.id=id;
    }
    public String toString(){
        return name+"---"+id;
    }

    @Override
    public int compareTo(Object o) {
        int id1=this.id;
        employee e=(employee) o;
        int id2=e.id;
        if (id1<id2){
            return -1;
        }
        else if(id1>id2){
            return +1;
        }
        else{
            return 0;
        }
    }

}
class DefComparision{
    public static void main(String[]args){
        employee e1=new employee("John",100);
        employee e2=new employee("Hart",101);
        employee e3=new employee("Amal",102);
        employee e4=new employee("Alhosban",103);
        employee e5=new employee("John",104);
        employee e6=new employee("Murali",105);
        employee e7=new employee("Mani",106);
        // Sorting based on the Ascending order of names
        TreeSet t=new TreeSet<>();
        t.add(e1);
        t.add(e2);
        t.add(e3);
        t.add(e4);
        t.add(e5);
        t.add(e6);
        t.add(e7);
        System.out.println(t);
        //-- Treeset with Customised Sorting Order based on the alphabetical order
        TreeSet t1=new TreeSet(new CustomComparator());
        t1.add(e2);
        t1.add(e3);
        t1.add(e4);
        t1.add(e5);
        t1.add(e6);
        t1.add(e7);
        System.out.println(t1);

    }
}
//---Customised Sorting Using comparator based on alphabets
class CustomComparator implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        employee e1=(employee) o1;
        employee e2=(employee) o2;
        String s1=e1.name;
        String s2=e2.name;
        return s1.compareTo(s2);// using default compareto method ofComparable(I)
}   }