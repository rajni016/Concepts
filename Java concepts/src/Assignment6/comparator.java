/*1.Create a pojo class(sharePrice(Long),compName) with list.
        LongComparator
        sort the data based on share price.
        Name Comparator
        sort the data based on CompName
*/

package Assignment6;

import java.util.ArrayList;
import java.util.Collections;

public class comparator  {
     public static void main(String[]args){
         ArrayList<ShareComp>obj=new ArrayList<>();

         obj.add(new ShareComp(20000L,"Zgoogle"));
         obj.add(new ShareComp(1000L,"microsoft"));
         obj.add(new ShareComp(1000L,"Ibm"));


         /*ShareComp Google=new ShareComp();
         Google.setCompanyname("Zgoogle");
         Google.setSharePrice(2000000L);

         ShareComp Microsoft=new ShareComp();
        Microsoft.setCompanyname("microsoft");
        Microsoft.setSharePrice(1000L);

         ShareComp IBM=new ShareComp();
         IBM.setCompanyname("ibm");
         IBM.setSharePrice(1000L);

         obj.add(Google);
         obj.add(Microsoft);
         obj.add(IBM);*/


         //Collections.sort(obj, new myownnamecomparator());//It will sort based on the name or price.
        // Collections.sort(obj, new myownpricecomparator());
         Collections.sort(obj, new myownpricecomparator().thenComparing(new myownnamecomparator()));// only one of these comparisions
         for(ShareComp arr:obj){
            System.out.println(arr.getSharePrice()+""+ arr.getCompanyname());
        }// after comparision we are iterating

         }
     }
     //creating this as separate class.
/* class myownnamecomparator implements Comparator<ShareComp>{

    @Override
    public int compare(ShareComp o1, ShareComp o2) {
        return o1.getCompanyname().compareTo(o2.getCompanyname());

    }
}
// only one comparision can be used at a time.But we can compare the two variables at a time(line 30)
class myownpricecomparator implements Comparator<ShareComp>{

    @Override
    public int compare(ShareComp price1, ShareComp price2) {
        return Long.compare(price1.getSharePrice(),price2.getSharePrice());
    }
}*/