package Collection.UtilityClasses;

import java.util.Arrays;
import java.util.List;

public class ArrayToListUtilty {
    public static void main(String[]args) {
        String[] s = {"A", "Z", "B"};
        List l = Arrays.asList(s);
        System.out.println("Before changes in array" + l);
        s[0] = "K";
        System.out.println("Changes in Array reflected in list too" + l);
        l.set(0, "L");// Cannot add or remove new elements but can change, this change is even reflected in array
        System.out.println("Changes in List reference reflected in Array too");
        for (String a1 : s) {
            System.out.println(a1);

        }

    }
}
