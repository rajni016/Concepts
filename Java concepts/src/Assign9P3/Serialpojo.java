package Assign9P3;
import java.io.Serializable;

public class Serialpojo implements Serializable {
    private static String messgae;
    private int number;
    private int id;
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static String getMessgae() {
        return messgae;
    }

    public static void setMessgae(String messgae) {
        Serialpojo.messgae = messgae;
    }

}
