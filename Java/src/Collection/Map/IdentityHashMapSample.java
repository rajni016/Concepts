package Collection.Map;

import java.util.HashMap;
import java.util.IdentityHashMap;


public class IdentityHashMapSample
{

        public static void main(String[] args) {
            HashMap m=new HashMap<>();
            String s1="Hi";
            String s2="Hi";
            m.put(s1,1);
            m.put(s2,2);

            System.out.println(m);
            IdentityHashMap<Object, Object> I=new IdentityHashMap<>();
            I.put(s1,1);
            I.put(s2,2);
            System.out.println(I);


        }
    }
