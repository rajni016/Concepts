public class Problem1 {
    public float addition(float a, float b){
        float add=a+b;
        String msg;
        if (add>100){
             msg="Number is bigger than 100";
        }
        else{
               msg="number is less than 100" ;
        }
        System.out.println(add + "\t" + msg);
        return add;
    }
    public static void main(String[]args){
        Problem1 a=new Problem1();
        a.addition(15.2f,30.5f);
        a.addition(1.555f,0.9999f);
        a.addition(100.1f,100f);
    }
}
