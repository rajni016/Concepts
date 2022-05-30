package Assignment4;

public class Problem2 {
    public void div(int num){
        int res=num/0;
        System.out.println(res);

    }
    public static void main(String[]args){
        Problem2 obj=new Problem2();
        try {
            obj.div(20);
        }
        catch (ArithmeticException e ){
            e.printStackTrace();
            System.out.println(e.getMessage());

        }
    }
}
