package Collection.Map;


import java.util.LinkedHashMap;
//Insertion Order is Preserved
public class LinkedHashmap {
    public static void main(String[]args) {
        LinkedHashMap m = new LinkedHashMap<>();
        m.put("A", 100);
        m.put("B", 200);
        m.put("C", 120);
        m.put("D", 145);
        m.put("F", "Easy");
        m.put("E", "Easy");
        m.put(200, 12);
        System.out.println(m);
        System.out.println(m.put("A", -4000));// Replacing the value and gives the old value
        System.out.println(m);

    }
}
