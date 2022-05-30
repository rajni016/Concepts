package Assign7P2;

public class Pojotree {
    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    private int marks;
    private String grade;
    public  Pojotree(int x, String G){
        this.marks=x;
        this.grade=G;

    }
}
