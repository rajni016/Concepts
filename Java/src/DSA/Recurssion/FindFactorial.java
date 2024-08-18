package DSA.Recurssion;

public class  FindFactorial
{
    //Static keyword is used to access this method without creating instance
    public static int FactorialOfNum(int n){
        if(n==0||n==1){
            return 1;

        }
        return n * FactorialOfNum(n-1);
    }
    public static void  main(String []args  ){
        int n=3;
       int x= FindFactorial.FactorialOfNum(n);
       System.out.println(x);
    }
}
