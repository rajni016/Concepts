package Collection.Map;

import java.util.Comparator;
import java.util.PriorityQueue;

public class QueueSample {

    public static void main(String[] args) {
        PriorityQueue<Integer> obj = new PriorityQueue<Integer>();
        //Empty Queue
        System.out.println(obj.peek());//gives null
       // System.out.println(obj.element());// peek or element give you first element/gives Exception
        for(int i=0;i<10;i++){
            obj.offer(i);
        }
        System.out.print(obj);
        //Removes the first element and returns the value

        System.out.println(obj.poll());
        System.out.println(obj);
    }
}
//---------------Customised Sorting using Comparator
//Output is different, as system is not supporting Priority Queue
class QueueSampleCustomised{

    public static void main(String[] args) {
        PriorityQueue<Integer> obj = new PriorityQueue<Integer>(new customisedorder());
        for(int i=0;i<10;i++){
            obj.offer(i);
        }

        System.out.print(obj);

    }
}
class customisedorder implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
       Integer I1=(Integer)o1;
        Integer I2=(Integer)o2;
      return I2.compareTo(I1);
    }
}