package Assign6P6;

public class Hashpojo {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBatchmonth() {
        return batchmonth;
    }

    public void setBatchmonth(String batchmonth) {
        this.batchmonth = batchmonth;
    }

    private String name;
    private String batchmonth;
    public Hashpojo(String x, String y){
        this.name=x;
        this.batchmonth=y;

    }
}

