package Assign8P1;

public class HApojo {
    private int Mblenum;

    public int getMblenum() {
        return Mblenum;
    }

    public void setMblenum(int mblenum) {
        Mblenum = mblenum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    public HApojo(int M, String N){
        this.Mblenum= M;
        this.name=N;
    }

}
