/*1.Create a pojo class(sharePrice(Long),compName) with list.
        LongComparator
        sort the data based on share price.
        Name Comparator
        sort the data based on CompName
*/
package Assignment6;

public class ShareComp {
    public ShareComp(Long sharePrice,String companyname){
        this.sharePrice=sharePrice;
        this.companyname=companyname;
    }
    public Long getSharePrice() {
        return sharePrice;
    }

    public void setSharePrice(Long sharePrice) {
        this.sharePrice = sharePrice;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    private Long sharePrice;
    private String companyname;
}
