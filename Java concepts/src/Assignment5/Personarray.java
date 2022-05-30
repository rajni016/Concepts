package Assignment5;

import java.util.ArrayList;

public class Personarray {
    public static void main(String[]args){
        ArrayList<Person>obj=new ArrayList<Person>();
        Person Lion =new Person();
        Lion.setName("Lion");
        Lion.setAge(25);
        Person Tiger =new Person();
        Tiger.setName("King");
        Tiger.setAge(25);
        Person Rabbit =new Person();
        Rabbit.setName("Bunny");
        Rabbit.setAge(2);
        obj.add(Lion);
        obj.add(Tiger);
        obj.add(Rabbit);
      for(Person it:obj){
          System.out.println(it.getAge()+" "+ it.getName());

      }
    }

}
