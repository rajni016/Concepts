package Assignment6;
//Hashset will not mainatain insertion order. Liked Hashset will give order in which we inserted the values.Tree set will give ascending order
import java.util.HashSet;
import java.util.concurrent.Callable;

public class Hashlistpojo {
    public static void main(String[]args){
        HashSet<coursepojo>obj=new HashSet<coursepojo>();
        obj.add(new coursepojo(99,"A+",101));
        obj.add(new coursepojo(35,"F",101));
        obj.add(new coursepojo(89,"A",101));
        obj.add(new coursepojo(99,"A+",98));
        obj.add(new coursepojo(85,"A",102));
        obj.add(new coursepojo(59,"C",101));
   for(coursepojo itr:obj){
       System.out.println(itr.getCoursenum()+"\t"+ itr.getGrade()+"\t"+itr.getMarks());
   }

    }
}
