package Assign6P3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class streamslist {
    public static void main(String[] args) {
        ArrayList<pojoclass> obj = new ArrayList<pojoclass>();
        obj.add(new pojoclass(101, "CSE"));
        obj.add(new pojoclass(100, "Mechanical"));
        obj.add(new pojoclass(99, "CSE"));
        obj.add(new pojoclass(102, "EEE"));
        obj.add(new pojoclass(90, "IT "));
        obj.stream().forEach((o) -> {
            System.out.println(o.getId() + "\t" + o.getCourse());

        });
        obj.stream().filter((ob) -> ob.getCourse().startsWith("C")).forEach((ob) -> {
            System.out.println(ob.getCourse());
        });
        obj.stream().filter((o)->o.getId()>100 ).forEach((o)->{
            System.out.println(o.getId());
                });
          /*List<String> duplicate= obj.stream().filter((o) -> o.getCourse().startsWith("I")).collect(Collectors.toList());
        }*/

    }
}