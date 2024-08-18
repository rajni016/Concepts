package DSA.Recurssion;

public class FibonacciSequenceFindingNum {
  //  Fibonacci Sequence= 0,1,1,2,3,5,8,13,21,34
    //Each number is sum of preceeding 2 numbers
    //Find the number at 5th position(Starting position is 0)
    public static int FindFibonacciNumber(int n){
        if(n<=1 ) {
            return n;
        }
        return FindFibonacciNumber(n-1)+FindFibonacciNumber(n-2);
    }
    public static void main(String []args){
        int n=6;
        int x=FibonacciSequenceFindingNum.FindFibonacciNumber(n);
        System.out.println(x);
    }
}
