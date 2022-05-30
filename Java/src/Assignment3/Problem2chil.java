package Assignment3;

public class Problem2chil extends Problem2parent {

    @Override
    public void printArray(String a, String b) {
        String message= a+b;
        System.out.println(message);
    }

    public static void main(String[]args){
        Problem2chil obj=new Problem2chil();
        obj.printArray("Java","Class");

    }
}
