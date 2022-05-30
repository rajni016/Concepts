package Databaseassign;

public class Pojoclassconnection {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    private String name;
   private String email;
   private String mobile;
   private int number;
   public Pojoclassconnection(String name,String email,String mobile,int number){
       this.name=name;
       this.email=email;
       this.mobile=mobile;
       this.number=number;
   }
}
