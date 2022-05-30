package Assignment4;
public class Problem3 {
    int x;
    int y;
    public int  add(){
        int res=x+y;
       // System.out.println(res);
        return res;
    }
    Problem3(int num1, int num2){
        this.x=num1;
        this.y=num2;
    }
    public static void main(String[]args){
       // Problem3 obj=new Problem3(100,100);
        //obj.add(100,200);
      // new Problem3(10,20);
        try{
            Problem3 obj=new Problem3(100,100);
           //
            // new Problem3(10,20);

            if(obj.add()<=100){
                System.out.println("there is no error");
            }
            else{
                throw new Exception("Error: Addition is greater than 100");
            }
        }
        catch (Exception myex){
            System.out.println(myex.getMessage());
        }

    }
}

