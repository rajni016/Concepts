package Collection.ListInterface;

import java.util.LinkedList;
import java.util.ListIterator;

public class ListIteratorCursor {
    public static void main(String[]args){
        LinkedList l=new LinkedList<>();
        l.add("A");
        l.add("B");
        l.add("C");
        l.add("D");
        l.add("E");
        l.add("F");
        l.add(10);

        System.out.println(l);
        ListIterator itr=l.listIterator();
        while (itr.hasNext()){
            String s=(String)itr.next();
            if(s.equals("A")){
                itr.remove();// removes
            }
            else if(s.equals("B")){
                itr.add("small b");//adds
            }
            else if(s.equals("C")){
                itr.remove();// removed
                itr.add(" small c");// added

            }

        }
        System.out.println(l);
        System.out.println(itr.getClass());

    }
}
