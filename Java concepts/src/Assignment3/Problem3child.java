package Assignment3;

public class Problem3child implements Problem3parent,Problem3parent2{

    @Override
    public void add(int x, int y) {
        int result=x+y;
        System.out.println(result);
    }

    @Override
    public void sub(int x, int y) {
        int result=x-y;
        System.out.println(result);

    }
    public static void main(String[]args){
        Problem3child obj=new Problem3child();
        obj.add(5,25);
        obj.sub(5,10);
    }
}
