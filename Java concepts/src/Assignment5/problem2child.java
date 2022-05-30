package Assignment5;

public class problem2child {

    public static void main(String[] args) {
        int x=5;
        int y=0;
        int result=x+y;

        try {
            if (result<10) {
                throw new Problem2("Entered number must be greater than 10");
            }
            else{
                System.out.println("entered number is correct"+"\t"+ x);
            }

        } catch (Problem2 e){
            System.out.println(e.getMessage());

        }
    }


}
