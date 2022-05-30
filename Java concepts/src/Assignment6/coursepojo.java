package Assignment6;
public class coursepojo {
//Used constructor
    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String grade) {
        Grade = grade;
    }

    public int getCoursenum() {
        return coursenum;
    }

    public void setCoursenum(int coursenum) {
        this.coursenum = coursenum;
    }
    private int marks;
    private String Grade;
    private int coursenum;

    public coursepojo(int m, String G, int c) {
        this.marks = m;
        this.Grade = G;
        this.coursenum = c;
    }
}