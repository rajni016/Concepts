package Assign7P3;

import Assign7P2.Pojotree;

public class Pojohash {
    private String name;
    public Pojohash(String x, int y ){
        this.name= x;
        this.id=y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

}
