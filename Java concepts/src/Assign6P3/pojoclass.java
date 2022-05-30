package Assign6P3;

public class pojoclass {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    private int id;
    private String course;
   public  pojoclass(int id1, String course1 )   {
       this.id=id1;
       this.course= course1;


    }
}
