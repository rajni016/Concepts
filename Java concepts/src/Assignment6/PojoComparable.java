package Assignment6;

public class PojoComparable implements Comparable<PojoComparable> {
    private String compName;
    private int Shareprice;
    public PojoComparable(String compName, int Shareprice){
        this.compName=compName;
        this.Shareprice=
                Shareprice;


    }
    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public int getShareprice() {
        return Shareprice;
    }

    public void setShareprice(int shareprice) {
        this.Shareprice = shareprice;
    }



    @Override
    public int compareTo(PojoComparable price) {
        return Integer.compare(this.getShareprice(),price.getShareprice());
    }
}
