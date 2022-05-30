package Assignment4;
public class Problem1{
    int num1;
    String x;
 Problem1(int num,String msg,long k){
     this.num1=num;
     this.x=msg;

      System.out.println("this is int"+"\t"+num);
     System.out.println("this is String"+"\t"+msg);
      System.out.println("this is Float"+k);

   }
   Problem1(int num2,String message,float y){
      // System.out.println(num2+"\t"+message);

   }

    public  void method() {
        System.out.println("here we are assigning local variable num to the global variable"+ "\t"+num1);
        System.out.println("Here we are assigning entred argument msg to x"+"\t"+x);

    }


   public static  void main(String []args){
         Problem1 obj=new Problem1(4,"Hello",58L);
         obj.method();
       new Problem1(4,"hi", 4890L);
       new Problem1(4,"this is constructor2",2456L);
   }
}
