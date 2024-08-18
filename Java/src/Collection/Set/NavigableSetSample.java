package Collection.Set;

import java.util.TreeSet;

public class NavigableSetSample {
    public static void main(String[]args){
        TreeSet <Integer> t=new TreeSet<>();

        t.add(1000);
        t.add(2000);
        t.add(3000);
        t.add(5000);
        t.add(4000);
        t.add(800);

        System.out.println(t);
        System.out.println(t.ceiling(3000));//Gives lowest value which is >=3000
        System.out.println(t.higher(3000));//Gives lowest value which is >3000
        System.out.println(t.floor(3000));//Gives highest value which is <=3000
        System.out.println(t.lower(3000));//Gives highest value which is <3000
        System.out.println(t.pollFirst());//Remove and returns First element
        System.out.println(t.pollLast());//Remove and returns Last element
        System.out.println(t.descendingSet());//Gives the set in reverse order




    }

}
