package Assignment6;

import java.util.Comparator;

class myownnamecomparator implements Comparator<ShareComp> {

    @Override
    public int compare(ShareComp o1, ShareComp o2) {
       return o1.getCompanyname().compareTo(o2.getCompanyname());
    }
}
class myownpricecomparator implements Comparator<ShareComp> {

    @Override
    public int compare(ShareComp price1, ShareComp price2) {
        return Long.compare(price1.getSharePrice(), price2.getSharePrice());
    }
}
