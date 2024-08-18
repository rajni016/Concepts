package Concepts.StringStringBuilderBuffer;

import java.util.Scanner;

public class StringMethods {
    public static void main(String[]args){
        System.out.println("Enter your city name");
        Scanner sc=new Scanner(System.in);
        String name= sc.nextLine();
        if(name.equals("warangal")){
            System.out.println("Hello Warangal");
        }
        else if(name.equals("hyderabad")){
            System.out.println("Hello Hyderabad");
        }
        else if(name.equals("chennai")){
            System.out.println("Hello Chennai");
        }
        else{
            System.out.println("City not found");
        }
    }
}
class ModifiedAboveProgram{
    public static void main(String[]args){
        System.out.println("Enter your city name");
        Scanner sc=new Scanner(System.in);
        String name= sc.nextLine().toLowerCase().trim();
        if(name.equals("warangal")){
            System.out.println("Hello Warangal");
        }
        else if(name.equals("hyderabad")){
            System.out.println("Hello Hyderabad");
        }
        else if(name.equals("chennai")){
            System.out.println("Hello Chennai");
        }
        else{
            System.out.println("City not found");
        }
    }
}