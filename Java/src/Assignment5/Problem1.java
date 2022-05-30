package Assignment5;

public class Problem1 {
    public static int method1 (int x) throws Exception{
        if(x!=0){
            System.out.println("Entered number is correct");
        }
        else{
            throw new Exception("Please enter correct number other than zero");
        }
        return x;
    }
    public static void main(String[]args){
        try {
            method1(55);
            method1(550);
            method1(0);

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
